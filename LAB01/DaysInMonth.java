package LAB01;
import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String strMonth;
        int year = -1;
        int days = 0;

        while (true) {
            System.out.print("Enter month (Name, Abbreviation, 3 letters, or Number): ");
            strMonth = keyboard.nextLine().trim();

            System.out.print("Enter year (non-negative number): ");
            if (keyboard.hasNextInt()) {
                year = keyboard.nextInt();
                keyboard.nextLine();
                if (year >= 0) {
                    days = getDaysInMonth(strMonth, year);
                    if (days != -1) break;
                }
            } else {
                keyboard.nextLine();
            }
            System.out.println("Invalid month/year. Please try again.");
        }

        System.out.println("Number of days: " + days);
        keyboard.close();
    }

    private static int getDaysInMonth(String month, int year) {
        month = month.toLowerCase();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (month.equals("january") || month.equals("jan.") || month.equals("jan") || month.equals("1")) return 31;
        if (month.equals("february") || month.equals("feb.") || month.equals("feb") || month.equals("2")) {
            return isLeap ? 29 : 28;
        }
        if (month.equals("march") || month.equals("mar.") || month.equals("mar") || month.equals("3")) return 31;
        if (month.equals("april") || month.equals("apr.") || month.equals("apr") || month.equals("4")) return 30;
        if (month.equals("may") || month.equals("5")) return 31;
        if (month.equals("june") || month.equals("jun") || month.equals("6")) return 30;
        if (month.equals("july") || month.equals("jul") || month.equals("7")) return 31;
        if (month.equals("august") || month.equals("aug.") || month.equals("aug") || month.equals("8")) return 31;
        if (month.equals("september") || month.equals("sept.") || month.equals("sep") || month.equals("9")) return 30;
        if (month.equals("october") || month.equals("oct.") || month.equals("oct") || month.equals("10")) return 31;
        if (month.equals("november") || month.equals("nov.") || month.equals("nov") || month.equals("11")) return 30;
        if (month.equals("december") || month.equals("dec.") || month.equals("dec") || month.equals("12")) return 31;

        return -1;
    }
}