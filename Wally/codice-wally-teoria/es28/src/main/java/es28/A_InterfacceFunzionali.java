package es28;

import java.util.function.*;

/*
 * ============================================================
 *  A — INTERFACCE FUNZIONALI (java.util.function)
 * ============================================================
 *
 *  Un'interfaccia funzionale ha UN SOLO metodo astratto.
 *  L'annotazione @FunctionalInterface è facoltativa ma consigliata
 *  (fa scattare un errore di compilazione se aggiungi più metodi astratti).
 *
 *  Tre modi equivalenti per creare un'istanza di una F.I.:
 *  ─────────────────────────────────────────────────────────
 *  1. Classe Anonima   → verboso, stile Java < 8
 *  2. Lambda           → conciso, stile Java 8+
 *  3. Method Reference → ancora più conciso quando esiste già il metodo
 * ============================================================
 */
public class A_InterfacceFunzionali {

    // ── CUSTOM FUNCTIONAL INTERFACE ──────────────────────────
    @FunctionalInterface
    interface Validator<T> {
        boolean validate(T input);
        // puoi avere metodi default/static in più senza rompere il contratto
        default Validator<T> negate() { return t -> !validate(t); }
    }

    // Metodi di supporto per gli esempi sui Method Reference
    static void stampa(String testo)              { System.out.println("Stringa: " + testo); }
    static void stampa(String testo, int numero)  { System.out.println("Doppia:  " + testo + " - " + numero); }

    public static void demo() {

        // ── 1. PREDICATE<T> ──────────────────────────────────
        // boolean test(T t)
        // Usato in: .filter(), .removeIf(), .noneMatch() / .anyMatch() / .allMatch()

        Predicate<Integer> isEven_anonima = new Predicate<>() {
            @Override public boolean test(Integer n) { return n % 2 == 0; }
        };
        Predicate<Integer> isEven_lambda = n -> n % 2 == 0;
        Predicate<Integer> isEven_mref   = A_InterfacceFunzionali::isEvenStatic; // vedi sotto

        System.out.println(isEven_lambda.test(4));  // true
        System.out.println(isEven_lambda.test(7));  // false

        // Composizione di Predicate
        Predicate<Integer> isPositive  = n -> n > 0;
        Predicate<Integer> isEvenAndPositive = isEven_lambda.and(isPositive);
        Predicate<Integer> isEvenOrPositive  = isEven_lambda.or(isPositive);
        Predicate<Integer> isOdd             = isEven_lambda.negate();
        System.out.println(isEvenAndPositive.test(4));  // true
        System.out.println(isOdd.test(3));              // true


        // ── 2. BIPREDICATE<T,U> ──────────────────────────────
        // boolean test(T t, U u)

        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println(isGreater.test(5, 3));   // true
        System.out.println(isGreater.test(1, 9));   // false


        // ── 3. FUNCTION<T,R> ─────────────────────────────────
        // R apply(T t)
        // Usato in: .map(), .flatMap()

        Function<String, Integer> lunghezza  = String::length;        // method reference
        Function<String, String>  toUpper    = String::toUpperCase;
        Function<String, Integer> lunga = toUpper.andThen(lunghezza); // composizione

        System.out.println(lunghezza.apply("Ciao"));  // 4
        System.out.println(lunga.apply("ciao"));      // 4


        // ── 4. BIFUNCTION<T,U,R> ─────────────────────────────
        // R apply(T t, U u)

        BiFunction<Integer, Integer, Integer> somma = (a, b) -> a + b;
        System.out.println(somma.apply(3, 7));  // 10


        // ── 5. CONSUMER<T> ───────────────────────────────────
        // void accept(T t)
        // Usato in: .forEach(), .peek()

        Consumer<String> printUC = str -> System.out.println(str.toUpperCase());
        printUC.accept("hello");  // HELLO

        // andThen: esegue prima il primo consumer poi il secondo
        Consumer<String> printLen = str -> System.out.println("len=" + str.length());
        Consumer<String> printBoth = printUC.andThen(printLen);
        printBoth.accept("java");  // JAVA \n len=4


        // ── 6. BICONSUMER<T,U> ───────────────────────────────
        // void accept(T t, U u)

        BiConsumer<String, Integer> printKV = (k, v) -> System.out.println(k + " → " + v);
        printKV.accept("età", 30);  // età → 30


        // ── 7. SUPPLIER<T> ───────────────────────────────────
        // T get()   — non accetta parametri, produce un valore

        Supplier<Double> rand   = Math::random;
        Supplier<String> hello  = () -> "Hello, World!";
        System.out.println(hello.get());  // Hello, World!


        // ── 8. UNARYOPERATOR<T> ──────────────────────────────
        // T apply(T t)   (specializzazione di Function<T,T>)
        // Usato in: List.replaceAll()

        UnaryOperator<String> toUpperOp = String::toUpperCase;
        System.out.println(toUpperOp.apply("mondo"));  // MONDO


        // ── 9. BINARYOPERATOR<T> ─────────────────────────────
        // T apply(T t1, T t2)   (specializzazione di BiFunction<T,T,T>)
        // Usato in: .reduce()

        BinaryOperator<Integer> max = Math::max;
        System.out.println(max.apply(42, 17));  // 42


        // ── 10. CUSTOM FUNCTIONAL INTERFACE ──────────────────
        Validator<String> noHtml = input -> !(input.contains("<") || input.contains(">"));
        System.out.println(noHtml.validate("Testo sicuro"));  // true
        System.out.println(noHtml.validate("<script>"));      // false
        System.out.println(noHtml.negate().validate("ok"));   // false


        // ── 11. METHOD REFERENCE — tutte e quattro le forme ──

        // a) Metodo STATICO di una classe: Classe::metodoStatico
        //    func.apply(x)  →  Classe.metodoStatico(x)
        BinaryOperator<Integer> maxRef = Math::max;
        System.out.println(maxRef.apply(10, 20));  // 20

        // b) Metodo d'ISTANZA su un oggetto specifico: oggetto::metodo
        //    func.apply(x)  →  oggetto.metodo(x)
        String testo = "Benvenuto in Java";
        Predicate<String> contiene = testo::contains;
        System.out.println(contiene.test("Java"));  // true

        // c) Metodo d'ISTANZA su tipo generico: Classe::metodo
        //    func.apply(obj)  →  obj.metodo()
        Function<String, Integer> lenRef = String::length;
        System.out.println(lenRef.apply("mondo"));  // 5

        // d) COSTRUTTORE: Classe::new
        //    func.apply(x)  →  new Classe(x)
        Function<String, String> factory = String::new;
        System.out.println(factory.apply("creato"));  // creato

        // Overload risolto dall'interfaccia di destinazione
        Consumer<String>         targetStr    = A_InterfacceFunzionali::stampa;
        BiConsumer<String,Integer> targetDoppio = A_InterfacceFunzionali::stampa;
        targetStr.accept("Ciao");
        targetDoppio.accept("Voto", 30);
    }

    // Metodo statico usato nel method reference per Predicate
    static boolean isEvenStatic(int n) { return n % 2 == 0; }
}
