package es28;

import java.util.*;
import java.util.stream.*;

/*
 * ============================================================
 *  L — STREAM PRIMITIVI (IntStream, LongStream, DoubleStream)
 * ============================================================
 *
 *  PERCHÉ ESISTONO?
 *  Stream<Integer> usa il boxing: ogni int viene avvolto in un Integer
 *  (oggetto sull'heap → overhead di memoria e GC).
 *  IntStream lavora direttamente con int primitivi → più efficiente.
 *
 *  I tre stream primitivi:
 *  • IntStream    → int
 *  • LongStream   → long
 *  • DoubleStream → double
 *
 *  PASSARE DA UN TIPO ALL'ALTRO:
 *  ┌────────────────────────────┬────────────────────────────────────────┐
 *  │ Da Stream<T> a primitivo   │ .mapToInt()  .mapToLong()  .mapToDouble│
 *  │ Da primitivo a Stream<T>   │ .boxed()  oppure  .mapToObj()          │
 *  │ Da IntStream a LongStream  │ .asLongStream()                        │
 *  │ Da IntStream a DoubleStream│ .asDoubleStream()                      │
 *  └────────────────────────────┴────────────────────────────────────────┘
 * ============================================================
 */
public class L_Stream_Primitivi {

    public static void demo() {

        // ── A. CREAZIONE DI IntStream ──────────────────────────

        // A1. range(start, endExclusive)  — come un for(i=start; i<end; i++)
        IntStream range1 = IntStream.range(0, 5);    // 0, 1, 2, 3, 4
        range1.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // A2. rangeClosed(start, endInclusive) — include l'estremo superiore
        IntStream range2 = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5
        range2.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // A3. of() — valori espliciti
        IntStream.of(10, 20, 30, 40).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // A4. generate() — infinito con Supplier (usa sempre .limit()!)
        IntStream.generate(() -> 7).limit(4).forEach(n -> System.out.print(n + " "));
        System.out.println();  // 7 7 7 7

        // A5. iterate() — infinito con accumulo
        IntStream.iterate(1, n -> n * 2).limit(8)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();  // 1 2 4 8 16 32 64 128

        // A6. Da array di int
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        IntStream daArray = Arrays.stream(arr);
        System.out.println(daArray.sum());  // 31


        // ── B. OPERAZIONI SPECIFICHE DEI PRIMITIVI ─────────────
        // Questi metodi NON esistono su Stream<T>!
        IntStream nums = IntStream.rangeClosed(1, 10);

        System.out.println(IntStream.rangeClosed(1,10).sum());           // 55
        System.out.println(IntStream.rangeClosed(1,10).min());           // OptionalInt[1]
        System.out.println(IntStream.rangeClosed(1,10).max());           // OptionalInt[10]
        System.out.println(IntStream.rangeClosed(1,10).average());       // OptionalDouble[5.5]
        System.out.println(IntStream.rangeClosed(1,10).count());         // 10

        // summaryStatistics() — tutti i valori in una volta
        IntSummaryStatistics stats = IntStream.rangeClosed(1, 100).summaryStatistics();
        System.out.println("Sum: "   + stats.getSum());      // 5050
        System.out.println("Min: "   + stats.getMin());      // 1
        System.out.println("Max: "   + stats.getMax());      // 100
        System.out.println("Avg: "   + stats.getAverage());  // 50.5
        System.out.println("Count: " + stats.getCount());    // 100


        // ── C. DA Stream<T> A PRIMITIVO ───────────────────────

        List<String> parole = List.of("mela", "pera", "banana", "uva");

        // .mapToInt(Function<T, int>) → IntStream
        IntStream lunghezze = parole.stream().mapToInt(String::length);
        System.out.println("Somma lunghezze: " + lunghezze.sum());  // 4+4+6+3 = 17

        // .mapToLong(Function<T, long>) → LongStream
        LongStream longStream = parole.stream().mapToLong(s -> (long) s.hashCode());

        // .mapToDouble(Function<T, double>) → DoubleStream
        DoubleStream doubleStream = parole.stream().mapToDouble(s -> s.length() * 1.5);
        System.out.printf("Media lunghezze * 1.5: %.2f%n", doubleStream.average().orElse(0));


        // ── D. DA PRIMITIVO A Stream<T> ───────────────────────

        // .boxed() → Stream<Integer> / Stream<Long> / Stream<Double>
        Stream<Integer> boxed = IntStream.rangeClosed(1, 5).boxed();
        List<Integer> lista = boxed.collect(Collectors.toList());
        System.out.println(lista);  // [1, 2, 3, 4, 5]

        // .mapToObj() — trasforma ogni primitivo in un oggetto (più flessibile di boxed)
        Stream<String> stringhe = IntStream.rangeClosed(1, 5)
            .mapToObj(n -> "Numero " + n);
        stringhe.forEach(System.out::println);


        // ── E. CONVERSIONI TRA PRIMITIVI ──────────────────────

        // IntStream → LongStream
        LongStream toLong = IntStream.rangeClosed(1, 5).asLongStream();

        // IntStream → DoubleStream
        DoubleStream toDouble = IntStream.rangeClosed(1, 5).asDoubleStream();

        // Somma di long grandi (evita overflow int)
        long sommaGrande = LongStream.rangeClosed(1, 1_000_000L).sum();
        System.out.println("Somma 1..1M: " + sommaGrande);  // 500000500000


        // ── F. CASI D'USO PRATICI ─────────────────────────────

        // Generare indici per una lista (alternativa al for classico)
        List<String> nomi = List.of("Alice", "Bob", "Carol");
        IntStream.range(0, nomi.size())
            .forEach(i -> System.out.println(i + ": " + nomi.get(i)));

        // Somma di una sequenza matematica
        int sumQuadrati = IntStream.rangeClosed(1, 10)
            .map(n -> n * n)
            .sum();
        System.out.println("Somma quadrati 1..10: " + sumQuadrati);  // 385

        // Fattoriale con LongStream (attenzione: > 20 va in overflow anche con long)
        long fattoriale10 = LongStream.rangeClosed(1, 10).reduce(1L, (a, b) -> a * b);
        System.out.println("10! = " + fattoriale10);  // 3628800

        // Numero di caratteri totali in una lista di stringhe
        long totaleCaratteri = parole.stream().mapToInt(String::length).asLongStream().sum();
        System.out.println("Totale caratteri: " + totaleCaratteri);
    }
}
