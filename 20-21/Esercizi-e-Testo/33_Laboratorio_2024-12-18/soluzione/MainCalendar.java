package it.univr.calendar;

public class MainCalendar {

	public static void main(String[] args) {
		Calendar cal = new Calendar(2024);
		System.out.println("start: " + cal.getStart());
		System.out.println("end: " + cal.getEnd());
		for (Calendar.Date date: cal)
			System.out.println(date);
	}
}