package es23.pkg2;

public class MainVarargsMethod {
    static int min(int... values) { // values is translated into an array
        int res = Integer.MAX_VALUE; // with the correct size
        for (int v : values)
            if (v < res) res = v;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(min(1, 0, 5));
        // the output is '0'
        System.out.println(min(3, 7, 2, 6, 9)); // the output is '2'
    }
}
