package it.univr;

public class ItalianDateAndTime extends ItalianDate {
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

	public String toString() {
		return hours + ":" + minutes + ":" + seconds + " " + super.toString();
	}

	public boolean equals(Object other) {
		return other instanceof ItalianDateAndTime idat &&
				seconds == idat.seconds &&
				minutes == idat.minutes &&
				hours == idat.hours &&
				super.equals(idat);
	}






}
