package it.univr.autosentences;

import java.util.stream.StreamSupport;

public class AutoSentencesStream {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Iterable<int[]> iterable = new Sequences(5, Constants.REPLACEMENTS.length);
		
		StreamSupport.stream(iterable.spliterator(), false)
			.parallel()
			//.map(idx -> new Sentence(idx))
			.map(Sentence::new)
			//.filter(sentence -> sentence.isAutoSentence())
			.filter(Sentence::isAutoSentence)
			//.forEach(sentence -> System.out.println(sentence));
			.forEach(System.out::println);

		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}
}
