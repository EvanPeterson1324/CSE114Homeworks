package CSE114_Homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #4
 */
public class PrimeFactorization {
    private static Scanner input;
    private static String numStrArr[];
    private static ArrayList<Integer> numList;

    
    public static void main(String[] args){
        input = new Scanner(System.in);
        numList = new ArrayList<>();
        
        System.out.print("Enter integers: ");
        int num = input.nextInt();
        if(num <= 0){
            System.out.println("Bad Input.");
            System.exit(0);
        }
        
        while(input.hasNextInt() && num > 0){
            numList.add(num); 
            num = input.nextInt();
            if(num <= 0){
                break; 
            } 
        }
        int product = computeProduct(numList);
        System.out.println("Product: " + product);
        System.out.print("Prime factorization: " );
        computeAndDisplayPrimeFac(product);
    }

    private static int computeProduct(List<Integer> numList) {
        int product = 1;
        for(Integer i : numList){
            product *= i;
        }
        return product;
    }

    private static void computeAndDisplayPrimeFac(int product) {
        int exp;
       // The first prime number is 2 so we loop from 2 until the product
       for(int i = 2; i <= product; i++){
           exp = 0;
           
           // While the product is an even number, 
           // we divide the product by the factor, 
           // and increment the exponent by 1.
           while((product % i) == 0){
               product /= i;
               exp++;
           }
           
            // If the exponent is  > 0, we print the factor to the power of the exp
           if(exp > 0){
               System.out.print(i + "^" + exp + " ");
           }
       }
        System.out.println();
    }
    
 
}
