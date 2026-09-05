package it.univr.sudoku;

import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/**
 * A sudoku in cui i numeri da 1 a 9 vengono rappresentati con elementi di tipo generico {@code E}.
 */
public class Sudoku<E> {

	/**
	 * Le caselle del Sudoku: contengono numeri tra 1 e 9, oppure 0 per indicare una casella vuota.
	 * La casella (0,0) è quella in alto a sinistra.
	 * La casella (8,8) è quella in basso a destra.
	 */
	private final int[][] matrix = new int[9][9];

	/** 
	 * Una funzione che dato un numero tra 1 e 9 restituisce l'elemento di tipo {@code E} per rappresentare quel numero.
	 */
	private final IntFunction<E> generator;
	
	/** 
	 * Una funzione che genera un numero intero (pseudo) casuale tra 1 e 9.
	 */
	private final Supplier<Integer> random;

	/**
	 * La dimensione di stampa di un elemento di tipo {@code E}.
	 * Si assume che tutti gli elementi di tipo {@code E} abbiano la stessa dimensione di stampa. 
	 * Questa informazione risulterà utile per stampare le caselle vuote del sudoku, per capire quanti spazi inserire.
	 */
	private final int elementSize;
	

	/**
	 * Costruttore di un nuovo Sudoku.
	 *
	 * @param empty Il numero di caselle vuote nel Sudoku.
	 * @param generator Una funzione per convertire un numero (1-9) in un elemento di tipo {@code E}.
	 * @param random Una funzione che genera un numero intero tra 0 e 8.
	 * @throws IllegalArgumentException quando {@code empty} non è tra 0 e 61 (inclusi).
	 */
	public Sudoku(int empty, IntFunction<E> generator, Supplier<Integer> random) {

		// lancia una IllegalArgumentException se {@code empty} non è tra 0 e 61 (inclusi)
		if (empty < 0 || empty > 61) {
			throw new IllegalArgumentException("Il numero di caselle vuote deve essere tra 0 e 61 (inclusi).");
		}
		
		this.generator = generator;
		this.random = random;
		
		// calcola quanto è lunga la stampa dell'elemento che rappresenta 1
		// (si assume che che la stampa di tutti gli elementi abbia la stessa lunghezza)
		elementSize = generator.apply(1).toString().length();
		
		// genera un Sudoku casuale completo
		generate();

		// cancella {@code empty} caselle a caso (mettendoci 0)
		hide(empty);
	}

	/**
	 * Restituisce una stringa che descrive il sudoku:
	 *  si tratta della stampa di una matrice 9x9, i cui elementi da 1 a 9 vengono prima trasformati
	 *  nell'oggetto di tipo {@code E} corrispondente (usando la funzione {@code generator}) e poi trasformati in stringhe.
	 * Vengono inserite anche le barrette di separazione orizzontale e verticale fra le 9 regioni del sudoku.
	 *
	 * @return La stringa che rappresenta il Sudoku.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int y = 0; y < 9; y++) {
			if (y == 3 || y == 6) sb.append("-".repeat(2+9*elementSize)).append("\n");
			for (int x = 0; x < 9; x++) {
				if (x == 3 || x == 6) sb.append("|");
				if (matrix[x][y] == 0)
					sb.append(" ".repeat(elementSize));
				else
					sb.append(generator.apply(matrix[x][y]).toString());
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	/**
	 * Nasconde (cioè pone a 0) esattamente {@code howMany} caselle del Sudoku scelte fra quelle che non sono già a 0.
	 */
	private void hide(int howMany) {
		while (howMany > 0) {
			int x = random.get();
			int y = random.get();
			if (matrix[x][y] != 0) {
				matrix[x][y] = 0;
				howMany--;
			}
		}
	}

	/**
	 * Genera un Sudoku risolto. [da non modificare]
	 */
	private void generate() {
		generate(0, 0);
	}

	/**
	 * Funzione ausiliaria per generare un Sudoku risolto. [da non modificare]
	 */
	private boolean generate(int x, int y) {
		int start = random.get();
		int nextX = (x + 1) % 9;
		int nextY = (nextX == 0) ? y + 1 : y;

		for (int num = start; num < start + 9; num++) {
			matrix[x][y] = (num % 9) + 1;
			if (isLegal(x, y) && (nextY == 9 || generate(nextX, nextY)))
				return true;
		}

		matrix[x][y] = 0;

		return false;
	}

	/**
	 * Determina se l'elemento alle coordinate (x,y) è legale. [da non modificare]
	 *
	 * @return {@code true} quando l'elemento è legale.
	 */
	private boolean isLegal(int x, int y) {
		return isHorizontallyUnique(x, y)
			&& isVerticallyUnique(x, y)
			&& isUniqueInRegion(x, y);
	}

	/**
	 * Determina se l'elemento alle coordinate (x,y) è unico nella sua riga.
	 *
	 * @return {@code true} quando l'elemento è unico.
	 */
	private boolean isHorizontallyUnique(int x, int y) {
		for (int xx = 0; xx < 9; xx++)
			if (xx != x && matrix[xx][y] == matrix[x][y])
				return false;

		return true;
	}

	/**
	 * Determina se l'elemento alle coordinate (x,y) è unico nella sua colonna.
	 *
	 * @return {@code true} quando l'elemento è unico.
	 */
	private boolean isVerticallyUnique(int x, int y) {
		for (int yy = 0; yy < 9; yy++)
			if (yy != y && matrix[x][yy] == matrix[x][y])
				return false;

		return true;
	}

	/**
	 * Determina se l'elemento alle coordinate (x,y) è unico nella sua regione.
	 *
	 * @return {@code true} quando l'elemento è unico.
	 */
	private boolean isUniqueInRegion(int x, int y) {
		int xx = x / 3 * 3;
		int yy = y / 3 * 3;
		for (int dx = xx; dx < xx + 3; dx++)
			for (int dy = yy; dy < yy + 3; dy++)
				if ((dx != x || dy != y) && matrix[dx][dy] == matrix[x][y])
					return false;

		return true;
	}
	
	/**
	 * Metodo accessore per la rappresentazione interna del Sudoku.
	 */
	public int[][] getMatrix() {
		return matrix;
	}
}
