package it.univr.dadi;

/**
 * Un dado truccatissimo a sei facce: lanciandolo, si ottiene sempre 6.
 */
public class D6Truccatissimo extends AbstractDado {

	public D6Truccatissimo() {
		super(6);
	}

	@Override
	public int lancio() {
		return 6;
	}
}
