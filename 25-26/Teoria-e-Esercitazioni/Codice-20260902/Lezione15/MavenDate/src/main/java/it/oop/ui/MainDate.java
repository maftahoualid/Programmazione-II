package it.oop.ui;

import it.oop.core.*;
import it.oop.core.Date;

import java.util.*;
import java.util.Map;

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
        //
        List<Date> dateList = new ArrayList<>();
        dateList.add(new AmericanDate(7,11,2025));
        dateList.add(new Date(9,11,2025));
        dateList.add(new TimeStamp(0,0,0, 8,11,2025));
        dateList.add(new AmericanDate(7,11,2025));
        System.out.println("list(" + dateList.size() +"): " + dateList.toString());
        Set<Date> dateSet = new HashSet<>();
        dateSet.add(new AmericanDate(7,11,2025));
        dateSet.add(new Date(9,11,2025));
        dateSet.add(new TimeStamp(0,0,0, 8,11,2025));
        dateSet.add(new AmericanDate(7,11,2025));
        System.out.println("set(" + dateSet.size() +"): " + dateSet.toString());
        AmericanDate usD1 = new AmericanDate(7,11,2025);
        AmericanDate usD2 = new AmericanDate(7,11,2025);
        System.out.println("usD1 ?= usD2: " + usD1.equals(usD2));
        System.out.println("hash(usD1): " + usD1.hashCode());
        System.out.println("hash(usD2): " + usD2.hashCode());
        //
        Map<String, FormattedDateConverter> converter = new HashMap<>();
        converter.put("usToIt", d -> new ItalianDate(d.getDay(), d.getMonth(), d.getYear()));
        converter.put("itToUs", d -> new AmericanDate(d.getDay(), d.getMonth(), d.getYear()));
        FormattedDate usDate = new AmericanDate(1, 1, 1970);
        FormattedDate itDate = converter.get("usToIt").convert(usDate);
        System.out.println(itDate.prettyPrint());
        for (String k : converter.keySet())
           System.out.println(converter.get(k).toString());
        //
        Collections.sort(dateList);
        System.out.println(dateList.toString());
        List<DateInterval> intvList = new LinkedList<>();
        intvList.add(new DateInterval(new Date(10, 1, 2025), new Date(31, 1, 2025)));
        intvList.add(new DateInterval(new Date(1, 1, 2025), new Date(20, 1, 2025)));
        // Collections.sort(intvList); // compile-time error
        // public interface Comparator<T> {
        // int compare(T o1, To2);
        // }
        Collections.sort(intvList, new Comparator<DateInterval>() {
           @Override
           public int compare(DateInterval di1, DateInterval di2) {
              return di1.getLeft().compareTo(di2.getLeft());
           }
        });
        System.out.println(intvList.toString());
        Collections.sort(intvList, (di1, di2) -> di2.getRight().compareTo(di1.getRight()));
        System.out.println(intvList.toString());
    }
}
