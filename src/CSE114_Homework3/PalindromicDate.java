package CSE114_Homework3;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Evan Peterson 
 * SBU ID: 108509452 
 * CSE 114 
 * Homework #3
 */
public class PalindromicDate {

    private static Scanner input; // Just a scanner
    private static String month, year, reformattedDate; // To hold the user input
    private static int numDays;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.print("Enter month: ");
        checkMonthValid();

        System.out.print("Enter day: ");
        checkValidDays();

        System.out.print("Enter year: ");

        checkValidYear();
        printReformedDate();
        printIsPalindrome();
    }

    /**
     * This method checks to see if the month inputed by the user is valid. If
     * not, it keeps asking for user input.
     */
    private static void checkMonthValid() {
        boolean isValid = false;
        while (!isValid) {
            month = input.next();
            for (Month m : Month.values()) {
                if (month.equalsIgnoreCase(m.getName())) {
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                System.out.print("Bad input.");
                System.exit(0);
            }
        }
    }

    private static void checkValidDays() {
        boolean isValid = false;
        int days = Month.valueOf(month.toUpperCase()).getNumDays();

        while (!isValid) {
            try {
                numDays = input.nextInt();

                // Checks if the value of the days is less or equal to the correct number.
                if (numDays <= days && numDays > 0) {
                    isValid = true;
                    break;
                }

                if (!isValid) {
                    System.out.print("Bad input.");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.print("Bad input.");
                System.exit(0);
            }

        }

    }

    private static void checkValidYear() {
        boolean isValid = false;

        while (!isValid) {
            year = input.next();
            try {
                if (year.length() > 4 || Integer.parseInt(year) < 1) {
                    System.exit(0);
                } else {
                    isValid = true;
                    break;
                }
            } catch (Exception e) {
                System.out.print("Bad input.");
                System.exit(0);
            }

        }
    }

    private static void printReformedDate() {
        // Print MM/DD/YY
        StringBuilder sb = new StringBuilder();
        sb.append(Month.valueOf(month.toUpperCase()).getMonthNum());
        sb.append("/");

        sb.append(numDays);
        sb.append("/");

        sb.append(year.substring(2, 4));

        reformattedDate = sb.toString();
        System.out.println("Reformatted date: " + reformattedDate);
    }

    private static void printIsPalindrome() {
        if (isPalindrome()) {
            System.out.println("Palindrome? yes");
        } else {
            System.out.println("Palindrome? no");
        }
    }

    private static boolean isPalindrome() {
        Stack myStack = new Stack();
        for (char ch : reformattedDate.toCharArray()) {
            myStack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!myStack.isEmpty()) {
            sb.append(myStack.pop());
        }

        if (sb.toString().equals(reformattedDate)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This enum is to help with handling input from the user. By making this an
     * inner class of sorts, we can make it easier to check if input is correct.
     * Each month has a String denoting its name and a number denoting its
     * number of days, as well as a number denoting what numerical position it holds on the calendar.
     */
    private enum Month {
        JANUARY("january", 30, "01"),
        FEBRUARY("february", 29, "02"),
        MARCH("march", 31, "03"),
        APRIL("april", 30, "04"),
        MAY("may", 31, "05"),
        JUNE("june", 30, "06"),
        JULY("july", 31, "07"),
        AUGUST("august", 31, "08"),
        SEPTEMBER("september", 30, "09"),
        OCTOBER("october", 31, "10"),
        NOVEMBER("november", 30, "11"),
        DECEMBER("december", 31, "12");

        private final String monthName;
        private final int numDays;
        private final String monthNum;

        Month(String newMonthName, int newNumDays, String newMonthNum) {
            monthName = newMonthName;
            numDays = newNumDays;
            monthNum = newMonthNum;
        }

        private String getName() {
            return monthName;
        }

        private int getNumDays() {
            return numDays;
        }

        private String getMonthNum() {
            return monthNum;
        }
    }
}
