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
		boolean letterIsInWord = getIndexOfLetterInWord(letter) > -1;
		if (letterIsInWord) {
			markCorrectGuess(letter);
		} else {
			wrongGuesses++;
		}
	}
	
	private int getIndexOfLetterInWord(final char letter) {
		return word.indexOf(letter);
	}
	
	private void markCorrectGuess(final char letter) {
		status[getIndexOfLetterInWord(letter)]=letter;
	}
}
