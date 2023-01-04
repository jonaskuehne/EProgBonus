import java.util.*;

/*
Author: J. Kuehne
Date: 09.11.2022
Lecture: EProg
Project: Bonus week 7
Summary:
    This file implements a game of roulette.
*/

public class Roulette {
	// class of players
	ArrayList<RPlayer> players;
	
	// ctor
	public Roulette() {
		 players = new ArrayList<RPlayer>();
	}
	
	// adds player
	public void register(RPlayer player) {
		players.add(player);
	}
	
	// random playing
	public int play() {
		// generate random number
		Random rand = new Random();
		// get number
		int number = rand.nextInt(37);
		// play
		force(number);
		// return random number
		return number;
	}
	
	// force some number
	public void force(int number) {
		// look at each registered player
		for (RPlayer player : players) {
			// plays
			if (player.plays()) {
				// see if won
				player.getWin(number);
			}
		}
	}
}