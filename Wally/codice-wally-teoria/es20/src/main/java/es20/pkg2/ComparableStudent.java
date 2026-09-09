package es20.pkg2;

public class ComparableStudent implements Comparable {
	String name;
	int matricola;
	
	public ComparableStudent(String name, int matricola) {
		this.name = name;
		this.matricola = matricola;
	}
	
	@Override
	public boolean equals(Object obj) { 
		// true se this è uguale a obj
		// false se this è diverso da obj

		// sempre prima verifica se i due oggetti sono lo stesso
        if (obj == this) return true;
        // se l'oggetto passato è nullo non è uguale
        if (obj == null) return false;
        // se l'oggetto non è istanza della stessa famiglia non è uguale
        if (!(obj instanceof ComparableStudent)) return false;
        // cast esplicito a tipo di this
        ComparableStudent student = (ComparableStudent) obj;
        // confronto dei campi: == per i tipi primitivi e equals() per gli String
        return matricola == student.matricola && name.equals(student.name);

	} 
	
	@Override
	public int compareTo(Object obj) { // used in Arrays.sort()
		// int<0 (-1) se this < obj
		// int=0 ( 0) se this = obj
		// int>0 (+1) se this > obj

		ComparableStudent other = (ComparableStudent) obj; // Downcasting
		return this.matricola - other.matricola; // Confronto campi
	}
	
}
