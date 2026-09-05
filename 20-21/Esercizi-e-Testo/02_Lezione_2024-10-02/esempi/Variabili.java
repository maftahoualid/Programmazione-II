package it.univr.helloworld;

public class Variabili {

	public static void main(String[] args) {
		final int i = 13;
		int j;
		j = 17;
		j++;
		j = j + 1;
		//i--;
		final double d = 3.1415;
		long l = 1234567;
		l = i;
		// non compila i = l;
		System.out.println(i);
		System.out.println(j);
		System.out.println(d);
		System.out.println(l);
		System.out.println("i = " + i);
		int a = 13;
		long b = 17;
		long c = a + b;
		double x = a / b; // fa divisione sui long !
		System.out.println("x = " + x);
	}

}
