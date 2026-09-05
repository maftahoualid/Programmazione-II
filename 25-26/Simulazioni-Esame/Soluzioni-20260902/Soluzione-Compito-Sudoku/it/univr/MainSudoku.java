package it.univr;

import it.univr.sudoku.Sudoku;
import it.univr.sudoku.Emoji;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.Random;
import java.util.stream.Stream;

public class MainSudoku {

	public static void main(String[] args) {
		System.out.println("Un sudoku di interi (1-9) con 61 caselle nascoste:");
		Sudoku<Integer> partialIntegerSudoku = new Sudoku<>(61, n -> n, new RandomNat());
		System.out.println(partialIntegerSudoku.toString());
		
		System.out.println("Un sudoku di interi (1-9) con 0 caselle nascoste:");
		Sudoku<Integer> completeIntegerSudoku = new Sudoku<>(0, n -> n, new RandomNat());
		System.out.println(completeIntegerSudoku.toString());
		
		System.out.println("Un sudoku di caratteri (A-I) con 30 caselle nascoste:");
		Sudoku<Character> characterSudoku = new Sudoku<>(30, n -> (char) ('A' + n - 1), new RandomNat());
		System.out.println(characterSudoku.toString());
		
		System.out.println("Un sudoku di emoji " + Arrays.toString(Emoji.values()) + " con 20 caselle nascoste:");
		Sudoku<Emoji> emojiSudoku = new Sudoku<>(20, n -> Emoji.values()[n - 1], new RandomNat());
		System.out.println(emojiSudoku.toString());
	}
	
	/**
	 * Classe innestata che genera un numero intero pseudo-casuale tra 0 e 8 (inclusi).
	 * La classe implementa l'intefaccia funzionale {@link java.util.function.Supplier},
	 *  che espone il metodo astratto {@code Integer get();}
	 */
	private static class RandomNat implements Supplier<Integer> {
	
		/**
	 	 * Oggetto di libreria per la generazione di sequenze di valori pseudo-casuali.
	 	 */
		private final Random rand = new Random();
		
		/**
	 	 * Implementazione del metodo astratto dell'interfaccia funzionale.
	 	 *
	 	 * @return un numero intero pseudo-casuale tra 0 e 8 (inclusi) 
	 	 */
		public Integer get() {
			return rand.nextInt(9);
		}
	}
	
	/**
	 * Metodo di utilità che conta il numero di caselle vuote nella griglia di un Sudoku. [da non modificare]
	 * 
	 * @return il numero di caselle vuote.
	 */	
	private static int countEmpty(int[][] matrix) {
		return (int) Stream.of(matrix)
			.flatMapToInt(IntStream::of)
			.filter(i -> i == 0)
			.count();
	}
}
