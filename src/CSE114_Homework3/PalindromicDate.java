
package CSE114_Homework3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #3
 */
public class PalindromicDate {
    /**
       Write a program that prompts the user to enter, in this order, 
       (i) a month (which could be in mixed uppercase/lowercase),
       (ii) a day and 
       (iii) a four-digit year. 

         Then, the program prints the date in a format MM/DD/YY,
         with exactly two digits each for the month, day and year. 
         It also prints whether the reformatted date is a palindrome.
        
     */
    
    private static String month;
    private static String day;
    private static String year;
    private static String[] validMonthsArray =  {
        "January", "February", "March", 
        "April", "May", "June", 
        "July", "August", "September", 
        "October", "November", "December"};
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        boolean isMonthValid, isDayValid, isYearValid;
        
        isDayValid = true;
        isYearValid = true;
        
        System.out.print("Enter a Month: ");
        month = input.next();
        
        while(!isMonthValid()){
            
        }
        
        
        System.out.print("Enter a Day: ");
        
        System.out.print("Enter a Year: ");
    }
    
    private static boolean isMonthValid(){
         for(String str : validMonthArray)
        
        
    }
}
