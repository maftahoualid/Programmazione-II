package es10;
public class MainSingletonPattern {
    public static void main(String[] args) {
        SingletonPattern ins1 = SingletonPattern.getInstance(); // CREA UNA ISTANZA
        SingletonPattern ins2 = SingletonPattern.getInstance(); // ISTANZA ESISTE GIÀ, PUNTA A QUELLA
        System.out.println("ins1==ins2? " + (ins1==ins2) ); // PUNTANO ENTRAMBI ALLA STESSA ISTANZA
    }
}
