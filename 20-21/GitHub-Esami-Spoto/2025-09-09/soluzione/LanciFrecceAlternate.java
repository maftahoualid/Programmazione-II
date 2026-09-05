package it.univr.dadi;

/**
 * Un tipo speciale di classe Lanci dove le barre degli istogrammi
 * sono stampate usando frecce di tipo alternato.
 */
public class LanciFrecceAlternate extends Lanci {

	public LanciFrecceAlternate(int quanti, Dado primoDado, Dado... altriDadi) {
		super(quanti, primoDado, altriDadi);
	}

	/**
	 * Restituisce una stringa lunga F caratteri (approssimato per difetto)
	 * che verra' usata per stampare la barra della riga i-esima dell'istogramma.
	 * In questa classe, questo metodo si ridefinisce in modo da fargli ritornare
	 * una freccia, fatta da un numero opportuno di caratteri '-' (per "i" pari)
	 * oppure '=' (per "i" dispari), seguiti infine da un solo carattere '>'.
	 */
	@Override
	protected String barra(int i, double F) {
		int approx = (int) F;
		if (approx == 0)
			return "";
		else
			return "-=".substring(i % 2, i % 2 + 1).repeat(approx - 1) + '>';
	}
}
