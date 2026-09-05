package it.univr.autosentences;

public class Sentence {
	private final int[] idx;
	private final String sentence;
	
	public Sentence(int[] idx) {
		this.idx = idx;
		this.sentence = String.format(Constants.FORMAT, replace());
	}

	public boolean isAutoSentence() {
		String s = sentence.toLowerCase();
		return count(s, 'a') == idx[0] &&
				count(s, 'e') == idx[1] &&
				count(s, 'i') == idx[2] &&
				count(s, 'o') == idx[3] &&
				count(s, 'u') == idx[4];
	}

	private int count(String s, char c) {
		int counter = 0;
		for (int pos = 0; pos < s.length(); pos++)
			if (s.charAt(pos) == c)
				counter++;

		return counter;
	}

	public String toString() {
		return sentence;
	}
	
	private String[] replace() {
		String[] result = new String[idx.length];
		for (int pos = 0; pos < result.length; pos++)
			result[pos] = Constants.REPLACEMENTS[idx[pos]];
		
		return result;
	}
}
