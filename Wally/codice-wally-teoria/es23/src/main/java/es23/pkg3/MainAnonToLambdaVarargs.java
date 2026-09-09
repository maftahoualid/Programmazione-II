package es23.pkg3;

public class MainAnonToLambdaVarargs {
    public static void main(String[] args) {
        SingleInterface singleInc = new SingleInterface() { // anonymous class
            @Override
            public int singleMethod(int... params) { 
                return params[0] + 1; 
            }
        };

        SingleInterface singleDec = params -> params[0] - 1; // with a lambda

        System.out.println(singleInc.singleMethod(3, 4, 5)); // the output is '4'
        System.out.println(singleDec.singleMethod(3, 2)); // the output is '2'
    }
}
