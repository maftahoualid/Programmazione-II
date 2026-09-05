public class StringPlayground {
	public static void main(String[] args) {
		String empty = new String();
		String str = "str";
		System.out.println("len(empty): " + empty.length());
		System.out.println("len(\"str\"): " + str.length());
		System.out.println(str.charAt(1));
		// str.charAt(1) = 'c'; // compile-time error
		String same = new String("str");
		System.out.println("str: " + str + " same: " + same);
		System.out.println("str ?= same: " + (str == same));
		String verySame = str;
		System.out.println("str ?= verySame: " + (str == verySame));
		System.out.println("str ?= same: " + str.equals(same));
		int n = 5;
		int sum = n*(n+1)/2;
		StringBuilder sb = new StringBuilder();
		sb.append("sum(").append(sum).append(")["); // fluent notation
		for (int i = 0; i < n; i ++)
			sb.append(" ").append(i);
		sb.append(" ]");
		System.out.println(sb.toString());
	}
}
