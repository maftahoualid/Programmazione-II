import java.util.Scanner;

public class MainDate {

    public static void main(String[] args) {
        System.out.println(Date.daysPerMonth(4));
        Date today = new Date(14, 10, 2025);
        Date tomorrow = new Date(15, 10, 2025);
        System.out.println(today.print());
        System.out.println(tomorrow.print());
        System.out.println(today.toString());
        String str = new String("ciao");
        System.out.println(str.toString());
        //
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the day: ");
        int day = sc.nextInt();
        System.out.println("Enter the month: ");
        int month = sc.nextInt();
        System.out.println("Enter the year: ");
        int year = sc.nextInt();
        sc.close();
        Date date = new Date(day, month, year);
        System.out.println(date.toString());
    }

}
