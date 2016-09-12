package CSE114_Homework2;


//package CSE114_HW2;

import java.util.Scanner;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #2
 */
public class GreekMoney {
    private static final String NUM_OBOLOI_PROMPT = "Enter number of oboloi: ";
    private static final String CALCULATED_OBOLOI_MSG = "That number of oboloi is equal to: \n";
    private static final String[] coinNames = {"Talents", "Minae", "Drachmae", "Oboloi"};
    
    private static int coins, rem, oboloi, drachmae, minae, talents;
    /**
     *  • 1 talent = 60 minae (plural of mina)
     *  • 1 mina = 70 drachmae (plural of drachma)
     *  • 1 drachma = 6 oboloi (plural of obolus)
     * @param args 
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        // Prompt the user for a number of oboloi
        System.out.print(NUM_OBOLOI_PROMPT);
        
        // Total number of coins, starting out in Oboloi's
        coins = input.nextInt();
        
        oboloi = coins % 6; // This is the lowest number of oboloi
        rem = coins / 6; // This is the remaining number of coins in Drachmae
        
        drachmae = rem % 70; // This is the lowest number of Drachmae.
        rem /= 70; // This is the remaining number of coins in Minae
        
        minae = rem % 60; // This is the lowest number of Minae.
        talents = rem / 60; // This is the lowest number of talents.
        
        printResult();
        
    }
    
    private static void printResult(){
        System.out.println(CALCULATED_OBOLOI_MSG);
        System.out.println( talents + " Talents\n"
                + minae + " Minae\n"
                + drachmae + " Drachmae\n"
                + oboloi + " Oboloi");
    }
}
