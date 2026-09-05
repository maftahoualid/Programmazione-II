package it.oop.ui;

import it.oop.core.*;
import it.oop.core.Date;

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
    }
}
