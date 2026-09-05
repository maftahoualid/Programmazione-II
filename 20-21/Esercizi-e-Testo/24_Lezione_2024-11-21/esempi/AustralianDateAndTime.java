package it.univr.dates;

import java.io.IOException;
import java.io.PrintWriter;

public class AustralianDateAndTime extends AustralianDate implements Time {
	private final int hours;
	private final int minutes;
	private final int seconds;

	public AustralianDateAndTime(int hours, int minutes, int seconds,
			int day, int month, int year) {
		
		super(day, month, year);

		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
	}

	protected void dump(PrintWriter writer) throws IOException {
		writer.println(seconds);
		writer.println(minutes);
		writer.println(hours);
		super.dump(writer);
	}

	protected Date mk(int day, int month, int year) {
		return new AustralianDateAndTime(0, 0, 0, day, month, year);
	}

	public String toString() {
		return hours + ":" + minutes + ":" + seconds + " " + super.toString();
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
}
