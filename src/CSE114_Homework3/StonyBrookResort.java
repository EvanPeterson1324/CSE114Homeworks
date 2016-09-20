/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE114_Homework3;

import java.util.Scanner;

/**
 *
 * @author evanpeterson
 */
public class StonyBrookResort {
    
    private static final double ADULT_PRICE = 125.00;
    private static final double ADULT_DISC_PRICE = 125.00 * .25;
    private static final double CHILD_PRICE = 75.00;
    private static Scanner input;
    private static int numAdults, numChildren, vacLength, numGuests;
    private static String startDay;
    
    public static void main(String[] args){
        input = new Scanner(System.in);
        System.out.print("Enter number of adults: ");
        numAdults = input.nextInt();
        
        System.out.print("Enter number of children: ");
        numChildren = input.nextInt();
        
        System.out.print("Enter length of vacation in days: ");
        vacLength = input.nextInt();
        
        System.out.print("Enter day of the week that vacation starts: ");
        startDay = input.next().toLowerCase();
        
        System.out.println("Total before discounts: " + calculateSubtotal());
        
    }
    
    /**
     * This method will calculate the sub-total of the vacation cost based on the user input.
     * We need to hold the values for the discounts, the subtotal before the discounts and charges, the charges, and the grand total
     */
    private static double calculateSubtotal(){
         double discountedDays,unDiscountedDays, adultCost, childCost, totalPrice;
         childCost = CHILD_PRICE * numChildren;
         childCost *= numChildren;
         
        // Case 1
        if(vacLength > 5){
            discountedDays = vacLength - 5;  // Holds the amount of discounted days
            adultCost = (ADULT_PRICE * 5) ;
            adultCost += (ADULT_DISC_PRICE * discountedDays);
            adultCost *= numAdults;
            
        } else{ // Case 2
            adultCost = (ADULT_PRICE * vacLength);
            adultCost *= numAdults;
        }
        
        // Case 3
        if(startDay.equals("monday") && vacLength < 4){
            adultCost -= 150.00;
        }
        
        numGuests = numChildren + numAdults;
        
        totalPrice = adultCost + childCost;
        if(numGuests > 5){
            totalPrice *= 1.05;
        } 
        
        return totalPrice;
    }
}
