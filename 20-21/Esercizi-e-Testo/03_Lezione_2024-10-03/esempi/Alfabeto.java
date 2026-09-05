package it.univr;

public class Alfabeto {

	public static void main(String[] args) {
		String s = "";
		char c = 'a';
		for (int i = 0; i < 20; i++) {
			s = s + c;
			System.out.println(s.length());
			//s = s.concat(String.valueOf(c));
			System.out.println(s);
		}

	}

}
