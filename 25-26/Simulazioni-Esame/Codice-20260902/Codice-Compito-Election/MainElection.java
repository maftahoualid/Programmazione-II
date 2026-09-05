package it.univr.election;

import java.util.Random;

public class MainElection {

	public static void main(String[] args) {
	
		// crea cinque partiti
		Party[] parties = new Party[] {
			new Party("Estremismo Quieto"),
			new Party("Il Fronte del Divano"),
			new Party("Astenuti Anonimi"),
			new Party("I Sempre Ultimi"),
			new Party("Movimento 4 Gatti")
		};

		// crea un'elezione inizialmente vuota
		Election election = new ElectionWinner();

		// aggiunge dei voti casuali ai partiti
		Random random = new Random();
		for (Party party: parties) {
			int votes = random.nextInt(10000);
			for (int i = 0; i < votes; i++)
				election.vote(party);
		}

		// stampa l'elezione con l'indicazione del vincitore
		System.out.println(election);
	}
}
