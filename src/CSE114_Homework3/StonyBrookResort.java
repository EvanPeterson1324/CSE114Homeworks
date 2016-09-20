
package CSE114_Homework3;

import java.util.Scanner;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #3
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
        
        calculateSubtotal();
    }
    
    /**
     * This method will calculate the sub-total of the vacation cost based on the user input.
     * We need to hold the values for the discounts, the subtotal before the discounts and charges, the charges, and the grand total
     */
    private static void calculateSubtotal(){
         double discountedDays,unDiscountedDays, adultCost, childCost, totalPrice, totalBeforeDiscount, discounts = 0, surcharge = 0;
         
         adultCost = numAdults * ADULT_PRICE;
         childCost = numChildren * CHILD_PRICE;
         totalBeforeDiscount = (adultCost * vacLength) + (childCost * vacLength);
         System.out.println("Total before discounts: " + totalBeforeDiscount);
         
         if(startDay.equalsIgnoreCase("monday") && vacLength < 5){
             discounts += 150;
         }
         
         if(vacLength > 5){
             discountedDays = vacLength - 5;
             unDiscountedDays = 5;
             discounts += (((ADULT_PRICE * .25) * numAdults) * discountedDays);
         }
         
         System.out.println("Discounts: $" + discounts);
         
         if(numChildren + numAdults > 5){
             surcharge = (totalBeforeDiscount * .05);
         }
         
         System.out.println("Surcharge: $" + surcharge);
         
         double total = (surcharge - discounts) + totalBeforeDiscount;
         
         System.out.println("Grand total: $" + total);
    }
}
