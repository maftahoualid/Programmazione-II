package es24.pkg1;

public class MainPair {
    public static void main(String[] args) {
        Pair p = new Pair("one", "two");
        String first = (String) p.getFirst(); // Cast esplicito verboso e tedioso

        Pair q = new Pair(1, 2); // Autoboxing da int a Integer
        // String second = (String) q.getSecond(); // RUN TIME ERROR
        // Ma a RUNTIME crasha con: java.lang.ClassCastException

        GenericPair<String> p1 = new GenericPair<String>("one", "two");
        // NON è necessario specificare il tipo new (lo prende dal tipo del riferimento) : diamond operator
        GenericPair<Integer> q1 = new GenericPair<>(1, 2); // cast implicito a Integer
        // GenericPair<int> z1 = new GenericPair<int>(1,2); // Solo tipi riferimento, NO tipi primitivi

        String first1 = p1.getFirst(); // Nessun cast necessario: p restituisce String garantita!
        // String second1 = q1.getSecond(); // COMPILE-TIME ERROR: Type mismatch

        GenericPair2<Integer,String> e1 = new GenericPair2<>(123, "Stringa");
        GenericPair2<Float,String> e2 = new GenericPair2<>(3.14f, "PI Value"); // cast implicito a Float


    }
}
