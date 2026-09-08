package es04;

public class MainStringhe {
    public static void main(String[] args) {
        String s1 = new String("Ciao");
        String s2 = "Ciao";
        String s3 = s2;
        String s4 = null;

        // concatenazione tra stringhe : crea una nuova stringa
        System.out.println(s1 + s2 + s3 + s4 + " :)");

        // ERRORE: NullPointerException
        // se provo a chiamare metodi di un oggetto non inizializzato 
        // (es: s4.toString() con s4 che punta a null)

        System.out.println(s1.length()); // 4
        System.out.println(s1.charAt(0)); // C 
        // System.out.println(s1.charAt(4)); // errore: out of bounds 
        System.out.println(s1.indexOf('o')); // 3
        System.out.println(s1.indexOf("ao")); // 2
        System.out.println(s1.indexOf('z')); // -1

        System.out.println(s1.substring(2)); // "ao"
        System.out.println(s1.substring(1,3)); // "ia"
        // System.out.println(s1.substring(1,5)); // errore : out of bounds

        System.out.println(s1.replace("a", "aaaa")); // "ciaaaao"
        
        System.out.println(s1 == s2); // false : non puntano allo stesso oggetto nello heap
        System.out.println(s1.equals(s2)); // true : confronto il contenuto delle stringhe
        System.out.println(s2 == s3); // true : ho assegnato il puntatore di s2 a s3

        System.out.println(s1 + 3); // viene fatto cast da int a str con String.valueOf() 

        System.out.println(String.format("Stringa: %s", s1)); // "Stringa: Ciao"
        System.out.printf("String: %s\n", s1); // "Stringa: Ciao"

        // s1.charAt(0) = 'D'  // errore: le stringhe sono immutabili
        // s1 = 'D' + s1.substring(1); // nuova stringa modificata
         
        StringBuilder sb1 = new StringBuilder("ABC");
        sb1.append("DEF"); // modifica della stessa stringa
        s4 = sb1.toString();

        String[] ss = { "abc", "def", "ghi" };
        StringBuilder sb2 = new StringBuilder();
        // Modifica di una stringa in "FLuent Notation"
        // sb.append() ritorna una ref alla stringa, posso chiamare ricorsivamente sb.append().append().append()
        sb2.append("Array(").append(5).append(") [");
        for (String i : ss) { 
            sb2.append(" " + i);
        }
        sb2.append(" ]");
        System.out.println(sb2.toString());
    
        // Array(5) [ abc def ghi ]
        sb2.insert(8, " :"); // Array(5) : [ abc def ghi ]        
        sb2.delete(5, 8); // Array : [ abc def ghi ]
        sb1.reverse(); // FEDCBA


        
    }
}
