package it.oop.ui;

import it.oop.core.*;
import it.oop.core.Date;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainDate {

    public static void main(String[] args) {
        Date.Builder dateBuilder = new Date.Builder(2025);
        Date d1 = dateBuilder.build(10,9);
        Date d2 = dateBuilder.build(10,-1);
        System.out.println(d1.toString());
        System.out.println(d2.toString());
        Time init = new Time() {
            @Override
            public int getHours() { return 0; }
            @Override
            public int getMinutes() { return 0; }
            @Override
            public int getSeconds() { return 0; }
            @Override
            public String toString() {
                return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
            }
        };
        System.out.println(init.toString());
        FormattedDateConverter toAmerican =
                d -> new AmericanDate(d.getDay(), d.getMonth(), d.getYear());
        System.out.println(toAmerican.convert(new ItalianDate(11, 11, 2025)) instanceof AmericanDate);
        //
        Pair<String, FormattedDate> event =
                new Pair<>("OOP exam", new ItalianDate(2, 2, 2026));
        System.out.println(event.getFirst() + " on " + event.getSecond().prettyPrint());
        DatePair dp = new DatePair(new Date(1,2,2025), new Date(1,1,2025));
        System.out.println("date pair: " + dp.toString());
        DateInterval di = new DateInterval(new Date(1,2,2025), new Date(1,1,2025));
        Pair<?,? extends FormattedDate> unknown = event;
        System.out.println(unknown.getFirst().toString() + " on " + unknown.getSecond().prettyPrint());
    }
}
