/*
Author: J. Kuehne
Date: 09.11.2022
Lecture: EProg
Project: Bonus week 7
Summary:
    This file contains tests for the bonus exercise of week 7.
*/

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RouletteTest {
	
	@Test
	public void testBasic1() {
		RPlayer alice = new RPlayer(200);
		RPlayer bob = new RPlayer(100);
		
		Roulette r1 = new Roulette();
		r1.register(alice);
		
		// Eine Runde Roulette wird gespielt wobei 12 ausgewaehlt wird
		r1.force(12);
		
		// Alice hatte noch keine Wette gesetzt
		assertEquals(200, alice.getBalance());
		assertEquals(100, bob.getBalance());
		
		r1.register(bob);
		
		// Alice und Bob setzen Wetten
		alice.setNumber(9, 10);
		assertEquals(190, alice.getBalance());
		
		bob.setNumber(4, 20);
		assertEquals(80, bob.getBalance());
		
		// Eine Runde Roulette wird gespielt wobei 9 ausgewaehlt wird
		r1.force(9);
		
		// Alice hat 369 gewonnen und Bob hat nichts gewonnen
		assertEquals(550, alice.getBalance());
		assertEquals(80, bob.getBalance());
		
		// Bob setzt eine neue Wette (Alice setzt keine Wette)
		bob.setOdd(80);
		assertEquals(0, bob.getBalance());
			
		// Eine Runde Roulette wird gespielt wobei 9 ausgewaehlt wird
		r1.force(9);
				
		// Bob 160 gewonnen und Alice hatte keine Wette bestaetigt
		assertEquals(550, alice.getBalance());
		assertEquals(160, bob.getBalance());
	}
	
	@Test
	public void testBasic2() {
		RPlayer alice = new RPlayer(200);
		RPlayer bob = new RPlayer(100);
		RPlayer clown = new RPlayer(300);
		
		Roulette r1 = new Roulette();
		r1.register(alice);
		r1.register(bob);
		r1.register(clown);
		
		// Alle setzen Wetten
		alice.setEven(50);
		bob.setNumber(12, 30);
		clown.setNumber(12, 30);
		
		// Clown setzt eine neue Wette, welche die alte Wette invalidiert
		clown.setNumber(5, 200);
		
		// Eine Runde Roulette wird gespielt wobei 12 ausgewaehlt wird
		r1.force(12);
		
		// Alice und Bob haben gewonnen und Clown hat verloren
		assertEquals(250, alice.getBalance());
		assertEquals(1150, bob.getBalance());
		assertEquals(70, clown.getBalance());
	}
	
	@Test
	public void testScam() {
		// set players
		RPlayer jonas = new RPlayer(420);
		RPlayer konas = new RPlayer(69);
		
		Roulette r = new Roulette();
		
		// sign in!
		r.register(jonas);
		r.register(konas);
		
		// place some bets
		// not very brave
		jonas.setEven(0);
		// very brave indeed!
		konas.setEven(70);
		// check balance
		assertEquals(420, jonas.getBalance());
		assertEquals(69, konas.getBalance());
		// play anyway!
		r.force(2);
		// won!
		// but not a lot it seems...
		assertEquals(420, jonas.getBalance());
		assertEquals(69, konas.getBalance());
		
		// new one!
		jonas.setEven(20);
		konas.setOdd(10);
		// check balance, that's quite the investment (minimize risk!)
		assertEquals(400, jonas.getBalance());
		assertEquals(59, konas.getBalance());
		// play!
		r.force(0);
		// but what's this?!
		assertEquals(400, jonas.getBalance());
		assertEquals(59, konas.getBalance());
		
		// new one! (we all see where this will end...)
		// all in!
		jonas.setNumber(8, jonas.getBalance());
		// here we go
		konas.setNumber(10, 19);
		// check balance (risky my man)
		assertEquals(0, jonas.getBalance());
		assertEquals(40, konas.getBalance());
		// oh no konas!
		konas.setNumber(8, 10);
		// that cash is a goner
		assertEquals(0, jonas.getBalance());
		assertEquals(30, konas.getBalance());
		// here we go
		r.force(8);
		// oh boy we're rich!
		assertEquals(14400, jonas.getBalance());
		assertEquals(390, konas.getBalance());
		
		// can't stop won't stop
		jonas.setNumber(5, jonas.getBalance());
		konas.setEven(konas.getBalance());
		// what's your family gonna say?!
		assertEquals(0, jonas.getBalance());
		assertEquals(0, konas.getBalance());
		// fingers crossed
		r.force(10);
		// ouff
		assertEquals(0, jonas.getBalance());
		assertEquals(780, konas.getBalance());
		
		// jonas no, you're out!
		// now this is almost tragic
		jonas.setNumber(8, jonas.getBalance());
		konas.setOdd(konas.getBalance());
		// empty...
		assertEquals(0, jonas.getBalance());
		assertEquals(0, konas.getBalance());
		// now this is it
		r.force(20);
		// we'll sue them no worries
		assertEquals(0, jonas.getBalance());
		assertEquals(0, konas.getBalance());
	}
	
}
