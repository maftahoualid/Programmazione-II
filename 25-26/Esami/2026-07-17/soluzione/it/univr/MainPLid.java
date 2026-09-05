package it.univr;

import it.univr.plid.*;
import java.util.List;

/**
 * Entry-point dell'applicazione.
 */
public class MainPLid {

	public static void main(String[] args) {
	
	  // inizializza due elenchi di parole
	  System.out.println("Parole iniziali:");
	  System.out.println("ciao");
	  System.out.println("Amico");
	  System.out.println("comE");
	  System.out.println("va\n");
	  String[] words1 = new String[] {"ciao", "Amico", "comE", "va"};
		Iterable<String> words2 = List.of("ciao", "Amico", "comE", "va");

    // istanzia e stampa gli identificatori
		ThreeStyleIdentifier id1 = new ThreeStyleIdentifier(words1);
		System.out.println("id1 (three-style) = " + id1);
		SnakeStyleIdentifier id2 = new SnakeStyleIdentifier(words2);
		System.out.println("id2 (snake-style) = " + id2);
		ThreeStyleIdentifier id3 = new ThreeStyleIdentifier(id1, id2);
		System.out.println("id3 (three-style) = " + id3);
		System.out.println("id3 (snake-style) = " + id3.toSnakeStyle());
	}
	
}
