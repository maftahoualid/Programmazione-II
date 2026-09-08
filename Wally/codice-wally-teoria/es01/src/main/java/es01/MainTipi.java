package es01;

public class MainTipi {

    //  QUI LE VARIABILI SONO INIZIALIZZATE DI DEFAULT
    public static void main(String[] args) {

        // QUI LE VARIABILI DEVONO ESSERE INIZIALIZZATE MANUALMENTE

        // TIPI PRIMITIVI
        
        boolean bool = false; 
        // true o false
        // !, &, |, &&, ||   
        // (con |,& valuto tutte le condizioni, con ||/&& esco appena trovo true/false)
        byte bytee = (byte) 127; 
        // da -127 a 128  
        // +, −, ∗, /, %, −
        short shortt = (short) 32767;
        // da -32.768 a 32.767
        // +, −, ∗, /, %, −
        int intero1 = 1; // INTERO DEFAULT
        // −2³¹, . . . , 2³¹ − 1
        // +, −, ∗, /, %, −
        long intero2 = 3000;
        // long min = Long.MIN_VALUE; // -9.223.372.036.854.775.808
        // long max = Long.MAX_VALUE; // +9.223.372.036.854.775.807
        float decimale1 = 1.222222222222222222222f; 
        // o 1.2F o (float)1.2
        // 6-7 cifre decimali
        // float min = Float.MIN_VALUE; // 1.4E-45
        // float max = Float.MAX_VALUE; // 3.4028235E38
        // +, −, ∗, /, %, −
        double decimale2 = 1.2222222222222222222222222222222222222222222222222; // DECIMALE DEFAULT
        // 15-17 cifre decimali
        // double min = Double.MIN_VALUE; // 4.9 × 10⁻³²⁴ 
        // double max = Double.MAX_VALUE; // 1.7976931348623157 × 10³⁰⁸
        // +, −, ∗, /, %, −
        char carattere = 'V'; 
        // o '\u0056' o 86
        // da 0 ('\u0000') a 65.535 ('\uffff') 

        System.out.printf("%s %s %s %s %s %s %s %s%n", bool, bytee, shortt, intero1, intero2, decimale1, decimale2, carattere);
        
        // CASTING ESPLICITI

        bytee = (byte) shortt;          // short to byte
        shortt = (short) intero1;       // int to short
        intero1 = (int) intero2;        // long to int
        intero2 = (long) decimale1;     // float to long
        decimale1 = (float) decimale2;  // double to float 

        // TIPI NON PRIMITIVI

        String s1 = new String("Ciao");
        String s2 = "Ciao";
        String s3 = s2;
        String s4 = null;

        System.out.println(s1 + s2 + s3 + s4);

        // ERRORE: NullPointerException
        // se provo a chiamare metodi di un oggetto non inizializzato 
        // (es: s4.toString() con s4 che punta a null)
    }    
}