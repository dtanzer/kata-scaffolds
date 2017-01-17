package net.davidtanzer.katas.hangman;

public class Hangman {
	
	private final String word;
	private final char[] status;
	private int wrongGuesses;
	
	public static Hangman start(final String word) {
		return new Hangman(word);
	}
	
	private Hangman(final String word) {
		this.word = word;
		this.status = word.replaceAll(".", "_").toCharArray();
	}
	
	public char[] getStatus() {
		return status;
	}
	
	public int getWrongGuesses() {
		return wrongGuesses;
	}
	
	public void guess(final char letter) {
		boolean letterIsInWord = word.indexOf(letter) > -1;
		if (letterIsInWord) {
			markCorrectGuess(letter);
		} else {
			wrongGuesses++;
		}
	}
	
	private void markCorrectGuess(final char letter) {
		for (int i = 0; i < word.length();i++) {
			if(word.charAt(i)==letter) {
				status[i] = letter;
			}
		}
	}
}
