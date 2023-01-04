/*
Author: J. Kuehne
Date: 09.11.2022
Lecture: EProg
Project: Bonus week 7
Summary:
    This file implements a class of roulette players.
*/

public class RPlayer {
	// class attributes
	private int balance;
	private boolean plays;
	private boolean evenBet;
	private boolean oddBet;
	private int numBet;
	private int stake;
	
	// ctor
	public RPlayer(int start) {
		// initial cash
		balance = start;
		resetBet();
	}
	
	// returns if player plays
	public boolean plays() {
		return plays;
	}
	
	// set number bet
	public boolean setNumber(int number, int bet) {
		// possible?
		if (balance - bet >= 0) {
			// we play!
			plays = true;
			balance -= bet;
			numBet = number;
			stake = bet;
			return true;
		} else {
			return false;
		}
	}
	
	// set even bet
	public boolean setEven(int bet) {
		// possible?
		if (balance - bet >= 0) {
			// we play!
			plays = true;
			balance -= bet;
			evenBet = true;
			stake = bet;
			return true;
		} else {
			return false;
		}
	}
	
	// set odd bet
	public boolean setOdd(int bet) {
		// possible?
		if (balance - bet >= 0) {
			// we play!
			plays = true;
			balance -= bet;
			oddBet = true;
			stake = bet;
			return true;
		} else {
			return false;
		}
	}
	
	// return balance
	public int getBalance() {
		return balance;
	}
	
	// reset bet
	private void resetBet() {
		plays = false;
		evenBet = false;
		oddBet = false;
		numBet = -1;
		stake = 0;
	}
	
	// get that cash!
	public void getWin(int num) {
		// even?
		if (evenBet) {
			if (num != 0 && num % 2 == 0) {
				balance += 2 * stake;
			}
		} else if (oddBet) {
			if (num % 2 == 1) {
				balance += 2 * stake;
			}
		} else {
			if (num == numBet) {
				balance += 36 * stake;
			}
		}
		
		// reset all
		resetBet();
	}
}
