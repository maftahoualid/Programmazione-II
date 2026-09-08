package es03;

// import es03.MainScanner; // non necessario se fa parte dello stesso ClassPath

public class MainImport {
    public static void main(String[] args) {
        // main in MainScanner è un metodo statico posso chiamarlo senza creare oggetti MainScanner
        MainScanner.main(null);

        System.out.println("Out");
        System.err.println("Err");
        System.currentTimeMillis();
    }
}
