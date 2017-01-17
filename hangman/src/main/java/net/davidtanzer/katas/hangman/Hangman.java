package net.davidtanzer.katas.hangman;

import java.util.ArrayList;
import java.util.Arrays;

public class Hangman {
	
	private int wrongGuesses;
	private String word ;
	
	private Hangman(final String word) {
		this.word = word;
	}
	
	public char[] getStatus() {
		char [] x = {'_','_','_','_','_'} ;
		return x;
	}
	
	public static Hangman start(final String word) {
		return new Hangman(word) ;
	}
	
	public int getWrongGuesses() {
		return wrongGuesses;
	}
	
	public void guess(final char letter) {
		boolean letterIsInWord = word.indexOf(letter) > -1;
		if (!letterIsInWord){
			wrongGuesses++;
		}
	}
}
