
//package CSE114_Homework3;

import java.util.Scanner;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #3
 */
public class DayOfWeek {
    private static Scanner input;
    private static String year, month, day;
    public static void main(String[] args){
        startingPrompt();
    }
    
    private static void startingPrompt(){
        input = new Scanner(System.in);
        
        System.out.print("Enter year (e.g., 1918): ");
        year = input.next();
        
        System.out.print("Enter month (1-12): ");
        month = input.next();
        
        System.out.print("Enter the day of the month (1-31): ");
        day = input.next();
        
        System.out.println("The day of the week is " + findDayOfWeek());
    }

    private static String findDayOfWeek() {
        int q = Integer.parseInt(day);
        int m = Integer.parseInt(month);
        int j = Integer.parseInt(year.substring(0, 2));
        int k = Integer.parseInt(year.substring(2, 4));
        
        if(Integer.parseInt(month) == Integer.parseInt(Month.JANUARY.getMonthNum())){
            m = 13;
            k -= 1;
        } else if(Integer.parseInt(month) == Integer.parseInt(Month.FEBRUARY.getMonthNum())){
            m = 14;
            k -= 1;
        }
        
        int numDay = (q + ((13 * (m + 1)) / (5)) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        String[] daysOfWeek = {"Saturday" , "Sunday" , "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        
        return daysOfWeek[numDay];
    }
    
    /**
     * This enum is to help with handling input from the user. By making this an
     * inner class of sorts, we can make it easier to check if input is correct.
     * Each month has a String denoting its name and a number denoting its
     * number of days, as well as a number denoting what numerical position it holds on the calendar.
     */
    private enum Month {
        JANUARY("january", "1"),
        FEBRUARY("february", "2"),
        MARCH("march", "3"),
        APRIL("april", "4"),
        MAY("may", "5"),
        JUNE("june", "6"),
        JULY("july", "7"),
        AUGUST("august", "8"),
        SEPTEMBER("september", "9"),
        OCTOBER("october", "10"),
        NOVEMBER("november", "11"),
        DECEMBER("december", "12");

        private final String monthName;
        private final String monthNum;

        Month(String newMonthName, String newMonthNum) {
            monthName = newMonthName;
            monthNum = newMonthNum;
        }

        private String getName() {
            return monthName;
        }


        private String getMonthNum() {
            return monthNum;
        }
    }
}

