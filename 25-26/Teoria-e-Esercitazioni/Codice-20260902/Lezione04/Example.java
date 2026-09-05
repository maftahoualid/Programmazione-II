public class Example {
	static float f1;
	static float f2 = 3.4f;
	static String s1;
	static final double PI = 3.14; 
	
	public static void main(String[] args) {
		int i1 = 6;
		int i2;
		char c1 = 'V';
		char c2 = 86;
		char c3 = '\u0056';
		String s2;
			
		System.out.println("i1: " + i1);
		// System.out.println("i2: " + i2); // compile-time error
		System.out.println("f1: " + f1);
		System.out.println("f2: " + f2);
		System.out.println("c1: " + c1 + " c2: " + c2 + " c3: " +c3);
		System.out.println("s1: " + s1);
		/*
		 System.out.println("s2: " + s2); // compile-time error
		 System.out.println(s1.toString()); // run-time error
		 PI = 3.0; // compile-time error
		*/
		int k = 0;
		System.out.println(true | k++ == 0);
		System.out.println("k (standard eval): " + k);
		k = 0;
		System.out.println(true || k++ == 0);
		System.out.println("k (short-circuit eval): " + k);
		//
		int n = 4;
		n ++;
		// int n = 8; // compile-time error
		{
			int m = 7;
			m ++;
		}
		{
			int m = 8;
			m --;
		}
		System.out.println("n: " + n);
		// System.out.println("m: " + m); // compile-time error
	}
}
