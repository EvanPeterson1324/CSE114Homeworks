package CSE114_Homework2;


//package CSE114_HW2;

import java.util.Scanner;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #2
 */
public class PetShelter {
    
    private static final String NUM_DOGS_PROMPT = "Enter number of dogs: ";
    private static final String NUM_CATS_PROMPT = "Enter number of cats: ";
    private static final String WEEKLY_BUDGET_PROMPT = "Enter weekly budget: $";
    private static final String AMT_SPENT_PER_WEEK = "Amount to spend per dog: $";
    
    /**
     * This main method allows for user input and outputs a result.
     * @param args 
     */
    public static void main(String[] args){
        
       // Scanner to read in input from the user
        Scanner input = new Scanner(System.in);
        
        // Prompt the user for a number of cats
        System.out.print(NUM_CATS_PROMPT);
        int numCats = Integer.parseInt(input.next());
        
        // Prompt the user for a number of dogs.
        System.out.print(NUM_DOGS_PROMPT);
        int numDogs = Integer.parseInt(input.next());
        
        // Prompt the user for the weekly budget
        System.out.print(WEEKLY_BUDGET_PROMPT);
        int budget= Integer.parseInt(input.next());

        // Display the Amount to spend per dog
        System.out.println("Amount to spend per dog: $" + calculateAmtPerDog(numDogs, numCats, budget));
    }
    
    /**
     * This method calculates the amount of money per week the person needs to spend per dog based on the input from the user.
     * @param numDogs
     * @param numCats
     * @param budget
     * @return 
     */
    private static int calculateAmtPerDog(int numDogs, int numCats, int budget) {
        // 2x * numDogs + x * numCats
        int catPrice = budget / ((2 * numDogs) + numCats);
        
        // The dog price is 2 times the price of the cat price.
        int dogPrice = 2 * catPrice;
        
        return dogPrice;
    }
}
