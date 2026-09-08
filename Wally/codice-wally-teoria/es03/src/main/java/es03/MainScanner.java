package es03;

import java.util.Scanner;

public class MainScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("User: ");
        String str = sc.nextLine(); // legge una stringa fino al a capo
        System.err.printf("Hi %s!", str);

        /*
        boolean bool = sc.nextBoolean();
        byte b = sc.nextByte();
        short s = sc.nextShort();
        int i = sc.nextInt();
        long l = sc.nextLong();
        float f = sc.nextFloat();
        double d = sc.nextDouble();
        */
        
        sc.close();
    }
}
