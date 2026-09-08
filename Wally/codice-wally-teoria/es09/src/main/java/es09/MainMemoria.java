package es09;
public class MainMemoria {
    public static void main(String[] args) {
        Memoria m = new Memoria();
        m.s1 = null;
        m.s2 = null;
        // m.s3 = null; // var locale a metodo, qui non esiste
        Memoria.s4 = null; // var statica di Memoria
        // m.s5 = null; // s5 è costante, non posso cambiarla
        System.gc(); // richiesta di garbage collection
    }
}
