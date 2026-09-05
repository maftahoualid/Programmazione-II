package it.oop.ui;

import it.oop.core.*;
import it.oop.core.Date;
import it.oop.exception.IllegalDateException;
import it.oop.exception.OrderdPairException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDate {

    public static void main(String[] args) {
        System.out.println("Insert day, month, year as numbers");
        int d = -1, m = -1, y = -1;
        boolean correct = false;
        while (correct == false) {
            try {
                Scanner sc = new Scanner(System.in);
                d = sc.nextInt();
                m = sc.nextInt();
                y = sc.nextInt();
                correct = true;
            } catch (InputMismatchException ime) {
                System.out.println("Input not valid, retry");
            }
        }
        try {
            FormattedDate date = new ItalianDate(d, m, y);
            System.out.println(date.toString());
        } catch (IllegalDateException ide) {
            System.out.println("Date not valid: " + ide.getMessage());
        }
        try {
            DateInterval di = new DateInterval(new Date(31, 1, 2025), new Date(1, 1, 2025));
        } catch (OrderdPairException ope) {
            ope.printStackTrace();
            throw new RuntimeException(ope);
        }
    }
}
