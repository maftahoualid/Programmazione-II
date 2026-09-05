package it.univr;

public class MainPair {

	// Integer rappresenta un int
	public static void main(String[] args) {
		Pair<String, Integer> p = new Pair<String, Integer>("ciao", 42);
		String f = p.getFirst();
		Integer s = p.getSecond();
		System.out.println(f);
		System.out.println(s);
	}

}
