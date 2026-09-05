package it.univr.autosentences;

public class AutoSentences {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int[] idx: new Sequences(5, Constants.REPLACEMENTS.length)) {
			Sentence sentence = new Sentence(idx);
			if (sentence.isAutoSentence())
				System.out.println(sentence);
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}
}
