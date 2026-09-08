package es07;

import java.util.Arrays;
import java.util.Scanner;

public class MainArr {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] intArr1 = { 1,2,3 }; 
        intArr1[2] = 3; 
        // intArr1[3] = 4; // errore: out of bounds

        System.out.println("Dimensione: ");
        int size = 3; /*sc.nextInt();*/
        int[] intArr2 = new int[size]; // array allocato dinamicamente
        System.out.println(intArr2.length); // size

        String[] strArr1 = {"abc", "def", "ghi"}; 
        String[] strArr2 = new String[]{"abc","def","ghi"};
        
        // System.out.println(strArr1==strArr2); // false
        // System.out.println(strArr1.equals(strArr2)); // false
        System.out.println(Arrays.equals(strArr1, strArr2)); // true

        // System.out.println(strArr1); // "[I@..."
        // System.out.println(strArr1.toString()); // "[I@..."
        System.out.println(Arrays.toString(strArr1)); // [abc, def, ghi]

        char[] charArr = new char[3]; 
        // System.out.println(charArr.length); // errore: charArr punta a null
        charArr[0] ='a'; charArr[1]='b';charArr[2]='c';
        for (int i = 0; i < charArr.length; i++) { System.out.println(charArr[i]); } // abc
        for (char c : charArr) { System.out.println(c); } // abc

        int[][] mat1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat2 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] pir = new int[3][]; 
        pir[0] = new int[1]; pir[1] = new int[2]; pir[2] = new int[3];
        
        // System.out.println(mat1==mat2); // false
        // System.out.println(mat1.equals(mat2)); // false
        // System.out.println(Arrays.equals(mat1, mat2)); // false
        System.out.println(Arrays.deepEquals(mat1, mat2)); // true

        // System.out.println(mat1); // [[I@42a57993
        // System.out.println(mat1.toString()); // [[I@42a57993
        // System.out.println(Arrays.toString(mat1)); // [[I@75b84c92, [I@6bc7c054, [I@232204a1]
        System.out.println(Arrays.deepToString(mat1));

    }
}
