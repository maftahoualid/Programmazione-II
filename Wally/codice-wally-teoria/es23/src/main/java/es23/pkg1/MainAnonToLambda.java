package es23.pkg1;

public class MainAnonToLambda {
    public static void main(String[] args) {
        // Con Classe Anonima
        SingleInterface singleInc = new SingleInterface() {
            @Override
            public int singleMethod(int param) { 
                return param + 1; 
            }
        };

        // Con Lambda (estremamente più concisa)
        SingleInterface singleDec = param -> param - 1;

        System.out.println("singleInc.singleMethod(5): " + singleInc.singleMethod(5)); // 6
        System.out.println("singleDec.singleMethod(5): " + singleDec.singleMethod(5)); // 4
    }
}
