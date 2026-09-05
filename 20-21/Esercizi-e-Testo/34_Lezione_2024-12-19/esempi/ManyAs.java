package it.univr.streams;

import java.util.stream.Stream;

public class ManyAs {

	public static void main(String[] args) {
		// "a", "aa", "aaa", "aaaa", .....
		Stream.iterate("a", s -> s + "a")
			.filter(s -> isPrime(s.length()))
			.limit(10)
			.map(s -> s + " [" + s.length() + "]")
			.forEach(s -> System.out.println(s));
	}
	
	private static boolean isPrime(int n) {
		for (int d = 2; d * d <= n; d++)
			if (n % d == 0)
				return false;

		return n >= 2;
	}

}
