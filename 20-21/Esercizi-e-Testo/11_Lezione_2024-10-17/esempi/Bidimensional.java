package it.univr;

import java.util.Arrays;

public class Bidimensional {

	public static void main(String[] args) {
		String[][] arr1 = {
				{ "ciao", "amico" },
				{ "hi", "friend" },
				{ "bonjour", "ami" }
		};
		
		System.out.println(arr1[2][1]);
		System.out.println(Arrays.toString(arr1[0]));
		
		arr1[0] = new String[3];
		arr1[0][1] = "buongiorno";
		arr1[0][2] = "buonasera";
		System.out.println(Arrays.toString(arr1[0]));

		arr1[1] = null;
		
	}

}
