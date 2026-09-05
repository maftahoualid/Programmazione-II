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
		// TODO
		System.out.println(partialIntegerSudoku.toString());
		
		System.out.println("Un sudoku di interi (1-9) con 0 caselle nascoste:");
		// TODO
		System.out.println(completeIntegerSudoku.toString());
		
		System.out.println("Un sudoku di caratteri (A-I) con 30 caselle nascoste:");
		// TODO
		System.out.println(characterSudoku.toString());
		
		System.out.println("Un sudoku di emoji " + Arrays.toString(Emoji.values()) + " con 20 caselle nascoste:");
		// TODO
		System.out.println(emojiSudoku.toString());
	}
	
	/**
	 * Classe innestata che genera un numero intero pseudo-casuale tra 0 e 8 (inclusi).
	 * La classe implementa l'intefaccia funzionale {@link java.util.function.Supplier},
	 *  che espone il metodo astratto {@code Integer get();}
	 */
	private static class RandomNat implements Supplier<Integer> {

		// TODO
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
