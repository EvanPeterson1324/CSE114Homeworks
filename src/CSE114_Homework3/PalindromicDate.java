/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE114_Homework3;

import java.util.Scanner;

/**
 *
 * @author Evanp
 */
public class PalindromicDate {
    private static Scanner input; // Just a scanner
    private static String month, day, year; // To hold the user input
    
    public static void main(String[] args){
        input = new Scanner(System.in);
        
    }
    
    
    /**
     * This enum is to help with handling input from the user.  By making this
     * an inner class of sorts, we can make it easier to check if input is correct.
     * Each month has a String denoting its name and a number denoting its number.
     */
    private enum Month{
        JANUARY("January", 1),
        FEBRUARY("Febuary", 2),
        MARCH("March", 3),
        APRIL("April", 4),
        MAY("May", 5),
        JUNE("June", 6),
        JULY("July", 7),
        AUGUST("August", 8),
        SEPTEMBER("September", 9),
        OCTOBER("October", 10),
        NOVEMBER("November", 11),
        DECEMBER("December", 12);
        
        private final String monthName;
        private final int monthNum;
        
        Month(String newMonthName, int newMonthNum){
            monthName = newMonthName;
            monthNum = newMonthNum;
        }
        
        private String getName(){
            return monthName;
        }
        
        private int getMonthNum(){
            return monthNum;
        }
        
    }
}
