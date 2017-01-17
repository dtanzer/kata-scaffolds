package net.davidtanzer.katas.hangman;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HangmanTest {
	
	private Hangman hangman;
	
	@Test
	public void shouldShowUnderscoreForEveryLetterInWordOnStart() {
		String word = "test1";
		
		hangman = Hangman.start(word);
		
		char[] status = hangman.getStatus();
		char[] expecteds = word.replaceAll(".", "_").toCharArray();
		assertArrayEquals(expecteds, status);
	}
	
	@Test
	public void shouldIncrementWrongGuessesOnWrongLetter() {
		String word = "a";
		char notInWord = 'b';
		
		hangman = Hangman.start(word);
		int wrongGuesses = hangman.getWrongGuesses();
		
		hangman.guess(notInWord);
		
		assertEquals("wrongGuesses", wrongGuesses + 1, hangman.getWrongGuesses());
	}
	
	@Test
	public void shouldNotIncrementWrongGuessesOnRightLetter() {
		String word = "a";
		char inWord = 'a';
		
		hangman = Hangman.start(word);
		int wrongGuesses = hangman.getWrongGuesses();
		
		hangman.guess(inWord);
		
		assertEquals("wrongGuesses", wrongGuesses, hangman.getWrongGuesses());
	}
	
	@Test
	public void shouldShowLetterForRightGuess() {
		String word = "abc";
		char inWord = 'b';
		hangman = Hangman.start(word);
		
		hangman.guess(inWord);
		
		char[] status = hangman.getStatus();
		char[] expected = {'_', 'b', '_'};
		assertArrayEquals("status", expected, status);
	}
	
	
	@Test
	public void shouldShowEveryOccurenceOfLetterForRightGuess() {
		String word = "abcb";
		char inWord = 'b';
		hangman = Hangman.start(word);
		
		hangman.guess(inWord);
		
		char[] status = hangman.getStatus();
		char[] expected = {'_', 'b', '_','b'};
		assertArrayEquals("status", expected, status);
	}
	
	@Test
	public void gameIsLostOnElevenWrongGuesses() {
		String word = "abcb";
		char inWord = 'e';
		hangman = Hangman.start(word);
		
		for(int i=0; i<12; i++){
			hangman.guess(inWord);
		}
		
		char[] status = hangman.getStatus();
		char[] expected = {'L', 'O', 'S', 'T'};
		assertArrayEquals("status", expected, status);
	}
	
}