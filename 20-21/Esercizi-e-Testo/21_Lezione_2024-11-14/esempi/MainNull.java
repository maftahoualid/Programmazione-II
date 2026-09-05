package it.univr;

import java.util.Random;

public class MainNull {

	public static void main(String[] args) {
		String s = null;
		Random random = new Random();
		switch (random.nextInt(4)) {
		case 0: s = "ciao"; break;
		case 1: s = "hello"; break;
		case 2: s = "bonjour"; break;
		}
		
		System.out.println("s è lungo " + s.length());
	}
}
