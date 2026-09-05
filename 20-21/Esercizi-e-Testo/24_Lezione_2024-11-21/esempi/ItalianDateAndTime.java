package it.univr.dates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ItalianDateAndTime extends ItalianDate implements Time {
	private final int hours;
	private final int minutes;
	private final int seconds;

	public ItalianDateAndTime(int hours, int minutes, int seconds,
			int day, int month, int year) {
		
		super(day, month, year);

		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
	}
	
	public ItalianDateAndTime(Scanner scanner) throws IOException {
		super(scanner);

		this.seconds = scanner.nextInt();
		this.minutes = scanner.nextInt();
		this.hours = scanner.nextInt();
	}

	protected void dump(PrintWriter writer) throws IOException {
		super.dump(writer);
		writer.println(seconds);
		writer.println(minutes);
		writer.println(hours);
	}

	protected Date mk(int day, int month, int year) {
		return new ItalianDateAndTime(0, 0, 0, day, month, year);
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
