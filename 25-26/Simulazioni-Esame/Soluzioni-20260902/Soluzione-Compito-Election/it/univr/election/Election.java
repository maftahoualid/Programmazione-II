package it.univr.election;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import static java.util.Collections.sort;
import java.util.Comparator;

/**
 * Un'elezione permette di registrare i voti ottenuti dai partiti politici.
 * Implementa l'interfaccia {@link java.lang.Iterable}.
 * Iterando su oggetti della classe si ottengono delle coppie partito e voti ottenuti,
 *  messe in ordine crescente per partito, appartenenti alla classe {@link it.univr.election.PartyVotes}.
 */
public class Election implements Iterable<PartyVotes> {

	/**
	 * Una mappa che registra i voti ottenuti dai pariti.
	 */
	private final List<PartyVotes> partyVotesList = new ArrayList<>();
	
	/**
	 * Il numero totale di voti registrati durante l'elezione.
	 */
	private int totalVotes = 0;
	
	/**
	 * Registra un voto per il partito indicato.
	 *
	 * @param party il partito a cui assegnare il voto.
	 */
	public final void vote(Party party) {
		Optional<PartyVotes> elem = partyVotesList.stream()
							.filter(pv -> pv.party.equals(party))
							.findAny();
		PartyVotes partyVotes = elem.orElse(new PartyVotes(party, 0));
		int votes = partyVotes.votes + 1;
		partyVotesList.remove(partyVotes);
		partyVotesList.add(new PartyVotes(partyVotes.party, votes));
		totalVotes ++;
	}

	/**
	 * Ritorna una stringa che descrive l'elezione, del tipo:
	 *  1  Astenuti Anonimi:       850 voti (3.55%)
	 *  2  Estremismo Quieto:     5349 voti (22.32%)
	 *  3  I Sempre Ultimi:       8482 voti (35.39%)
	 *  4  Il Fronte del Divano:  7769 voti (32.42%)
	 *  5  Movimento 4 Gatti:     1515 voti (6.32%)
	 *
	 * I partiti sono riportati in ordine crescente, con a sinistra un indice crescente del partito (da 1 in su).
	 * Dopo il nome del partito viene riportato il numero dei voti ottenuti e la percentuale ottenuta fra tutti i voti espressi.
	 */
	@Override
	public String toString() {
		int index = 1;
		String result = "";
		Iterator<PartyVotes> it = this.iterator();
		while (it.hasNext()) {
			PartyVotes partyVotes = it.next();
			float percentage = (float) partyVotes.votes / totalVotes * 100;
			String row = String.format("%d\t%s:\t%4d voti (%.2f%%)\n", index++, partyVotes.party, partyVotes.votes, percentage);
			result += row;
		}
		
		return result;
	}

	/**
	 * Iterando su questo oggetto, si ottengono delle coppie partito e voti ottenuti,
	 * messe in ordine crescente per partito.
	 */
	@Override
	public final Iterator<PartyVotes> iterator() {
		sort(partyVotesList, new Comparator<PartyVotes>() {
			@Override
			public int compare(PartyVotes a, PartyVotes b) {
				return a.party.compareTo(b.party);
			}
		});
			
		return partyVotesList.iterator();
	}
}
