package it.oop.ui;

import it.oop.core.AmericanDate;
import it.oop.core.FormattedDate;
import it.oop.core.ItalianDate;

import java.util.List;
import java.util.stream.Stream;
import it.oop.core.Date;
import static java.util.stream.Stream.generate;

public class MainStream {
    public static void main(String[] args) {
        // "a", "aa", "aaa", ...
        Stream<String> stream = Stream.iterate("a", s -> s + "a")
                .filter(s -> s.length() % 2 == 1)
                .limit(10);
        List<String> list = stream.toList();
        System.out.println(list.toString());
        //
        List<Integer> list2 = Stream.generate(() -> (int) (Math.random()*20))
                .filter(i -> isPrime(i))
                .limit(10)
                .toList();
        System.out.println(list2.toString());
        //
        Stream.of(new ItalianDate(15,1,2025), new Date(16,1,2025), new ItalianDate(2,2,2025))
                .filter(d -> d instanceof ItalianDate)
                .map(d -> new AmericanDate(d.getDay(),d.getMonth(),d.getYear()))
                .forEach(System.out::println);
    }

    private static boolean isPrime(int n) {
        return n == 0 ? false : Stream.iterate(1, i -> i + 1)
                .limit(n)
                .map(i -> n % i)
                .filter(i -> i == 0)
                .count() <= 2;
    }
}
