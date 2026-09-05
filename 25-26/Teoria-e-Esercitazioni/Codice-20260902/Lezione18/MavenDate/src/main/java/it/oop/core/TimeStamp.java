package it.oop.core;

public class TimeStamp extends Date implements Time {
    protected final int seconds;
    protected final int minutes;
    protected final int hours;

    public TimeStamp(int seconds, int minutes, int hours, int day, int month, int year) {
        super(day, month, year);
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    @Override
    public int getSeconds() {
        return seconds;
    }
    @Override
    public int getMinutes() {
        return minutes;
    }
    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return String.format("%s[%02d:%02d:%02d]", super.toString(), hours, minutes, seconds);
    }

    @Override
    public boolean equals(Object other) {
        if (super.equals(other) == false) return false;
        if (!(other instanceof TimeStamp)) return false;
        TimeStamp otherAsTimeStamp = (TimeStamp) other;
        return hours == otherAsTimeStamp.getHours() &&
                minutes == otherAsTimeStamp.getMinutes() &&
                seconds == otherAsTimeStamp.getSeconds();
    }
}
