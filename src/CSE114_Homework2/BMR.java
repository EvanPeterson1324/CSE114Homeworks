package CSE114_Homework2;

import java.util.Scanner;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #2
 */
public class BMR {
    
    private static final String WEIGHT_PROMPT = "Enter the person's weight in pounds: ";
    private static final String HEIGHT_PROMPT = "Enter the person's height in inches: ";
    private static final String AGE_PROMPT = "Enter the person's age in years: ";
    private static final String BMR_FOR_MALE = "BMR for a man: ";
    private static final String BMR_FOR_WOMAN = "BMR for a woman: ";
    
    private static Scanner input = new Scanner(System.in);
    
    static int age, maleS, womanS;
    static double weight, height, BMR, heightInCm, weightInKg;
            
    public static void main(String[] args){
        // 
        maleS = 5; 
        womanS = -161;
        
        // Prompt for the Weight.
        System.out.print(WEIGHT_PROMPT);
        weight = input.nextDouble();
        
        // Prompt for the Height.
        System.out.print(HEIGHT_PROMPT);
        height = input.nextDouble();
        
        // Prompt for the Age.
        System.out.print(AGE_PROMPT);
        age = input.nextInt();
        
        // Convert weight in pounds to weight in kilograms.
        weightInKg = poundsToKilo();
        
        // Convert height in inches to height in cm.
        heightInCm = inchesToCm();
        
        // Prints the BMR for a male according the input.
        System.out.println(BMR_FOR_MALE + calculateBMRMale() + " kcal/day");
        
        // Prints the BMR for a woman given the input.
        System.out.println(BMR_FOR_WOMAN + calculateBMRFemale() + " kcal/day");
    }
    
    private static double poundsToKilo(){
        return weight * 0.453592 ;  
    }
    
    private static double inchesToCm(){
        return height * 2.54;
    }
    
    private static double calculateBMRMale(){
        return (10 * weightInKg) + (6.25 * heightInCm) - (5 * age) + (maleS);
    }
    
    private static double calculateBMRFemale(){
        return (10 * weightInKg) + (6.25 * heightInCm) - (5 * age) + (womanS);
    }
    
}
