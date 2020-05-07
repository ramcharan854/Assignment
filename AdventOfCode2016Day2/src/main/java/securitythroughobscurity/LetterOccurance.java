package main.java.securitythroughobscurity;

import java.util.Comparator;

public class LetterOccurance implements Comparable<LetterOccurance> {

	public char letter;
	public int occurence;

	public LetterOccurance(char letter) {
		this.letter = letter;
		this.occurence = 0;
	}

	@Override
	public int compareTo(LetterOccurance o) {
		return Character.compare(letter, o.letter);
	}

	public static Comparator<LetterOccurance> compareByOccurrence() {
        return Comparator.comparingInt((LetterOccurance o) -> o.occurence)
                .reversed()
                .thenComparingInt(o -> o.letter);
    }

}
