package it.univr.election;

import java.util.Iterator;

/**
 * Un'elezione la cui stampa aggiunge l'indicazione di quale partito è risulto vincitore (con maggior voti).
 * Estende la classe {@link it.univr.election.Election}.
 */
public class ElectionWinner extends Election {

	/**
	 * Si comporta come il metodo {@code toString} della superclasse, ma in più
	 * aggiunge in coda l'indicazione del partito che ha vinto le elezioni, del tipo "Vince Il Movmento Fermo".
	 * In particolare, vince l'elezione il partito che ha ottenuto più voti.
	 * A parità di voti, vince il partito che viene prima in ordine alfabetico.
	 * Se non ci fossero partiti (elezione vuota), aggiunge l'indicazione "Non ci sono vincitori".
	 */
	@Override
	public String toString() {
		Party winner = getWinner();
		if (winner == null) return "Non ci sono vincitori";
		else return super.toString() + "\nVince " + winner + "\n";
	}
	
	/**
	 * Restituisce il parito vincitore (con maggior voti).
	 *
	 * @return il partito vincitore.
	 */
	private Party getWinner() {
		Party winner = null;
		int max = 0;
		Iterator<PartyVotes> it = this.iterator();
		while (it.hasNext()) {
			PartyVotes partyVotes = it.next();
			if (winner == null || partyVotes.votes > max) {
				winner = partyVotes.party;
				max = partyVotes.votes;
			}
		}

		return winner;
	}
}
