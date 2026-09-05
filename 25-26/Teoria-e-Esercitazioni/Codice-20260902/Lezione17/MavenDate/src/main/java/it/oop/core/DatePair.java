package it.oop.core;

public class DatePair extends Pair<Date, Date> {
    public DatePair(Date left, Date right) {
        super(left, right);
    }

    public Date getLeft() { return getFirst(); }
    public Date getRight() { return getSecond(); }

    @Override
    public String toString() {
        Date l = getLeft();
        Date r = getRight();
        return String.format("[%s .. %s]", l.toString(), r.toString());
    }
}
