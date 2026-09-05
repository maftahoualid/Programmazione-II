package it.univr.dadi;

public class Main {

	public static void main(String[] args) {
		System.out.println("Lanciamo 20 volte due dadi a sei facce");
		Lanci l = new Lanci(20, new D6(), new D6());
		System.out.println("Lanci ottenuti: " + l);
		System.out.println(l.frequenze());

		System.out.println("Lanciamo 10000 volte un dado a sei facce");
		l = new Lanci(10000, new D6());
		System.out.println(l.frequenze());

		System.out.println("Lanciamo 10000 volte un dado a sei facce truccato");
		l = new Lanci(10000, new D6Truccato());
		System.out.println(l.frequenze());

		System.out.println("Lanciamo 10000 volte un dado a sei facce truccatissimo");
		l = new Lanci(10000, new D6Truccatissimo());
		System.out.println(l.frequenze());

		System.out.println("Lanciamo 10000 volte un dado a otto facce, uno a sei facce truccato e uno a dieci facce");
		l = new Lanci(10000, new D8(), new D6Truccato(), new D10());
		System.out.println(l.frequenze());

		System.out.println("Lanciamo 10000 volte tre dadi a sei facce, usando frecce");
		l = new LanciFrecce(10000, new D6(), new D6(), new D6());
		System.out.println(l.frequenze());
		
		System.out.println("Lanciamo 10000 volte tre dadi a sei facce, usando frecce alternate");
		l = new LanciFrecceAlternate(10000, new D6(), new D6(), new D6());
		System.out.println(l.frequenze());

		System.out.println("Lanciamo -10000 volte tre dadi a sei facce, usando frecce alternate: andra' in eccezione");
		new LanciFrecceAlternate(-10000, new D6(), new D6(), new D6());
	}
}