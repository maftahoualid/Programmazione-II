package it.univr.dadi;

/**
 * Un dado truccato a sei facce: 5 e 6 escono ciascuno mediamente
 * nel 30% dei casi, mentre 1, 2, 3 e 4 escono ciascuno mediamente
 * nel 10% dei casi.
 */
public class D6Truccato extends AbstractDado {

	public D6Truccato() {
		super(6);
	}

	@Override
	public int lancio() {
		int r = random.nextInt(10);
		return
				switch (r) {
				case 4,	5, 6 -> 5; // 5 esce in 3 casi su 10
				case 7, 8, 9 -> 6; // 6 esce in 3 casi su 10
				default -> r + 1; // le altre facce escono ciascuna in un caso su 10
				};
	}
}
