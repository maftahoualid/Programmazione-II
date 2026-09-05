package it.univr.election;

/**
 * Una coppia che rappresenta un partito ed i voti ottenuti in un'elezione. [da non modificare]
 */
public class PartyVotes {

	/**
	 * Il partito politico.
	 */
	public final Party party;
	
	/**
	 * I voti ottenuti.
	 */
	public final int votes;

	/**
	 * Crea uno coppia con il parito politioc ed i voti ottenuti.
	 * 
	 * @param party il partito.
	 * @param votes i voti ottenuti.
	 */
	public PartyVotes(Party party, int votes) {
		this.party = party;
		this.votes = votes;
	}

	/**
	 * Restituisce una stringa del tipo "Il Movimento Fermo: 123"
	 */
	@Override
	public String toString() {
		return party + ": " + votes;
	}
}
