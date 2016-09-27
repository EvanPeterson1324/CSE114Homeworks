package CSE114_Homework4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Evan Peterson 
 * SBU ID: 108509452 
 * CSE 114 
 * Homework #4
 */
public class BaseToBase {
    private static Scanner input;
    private static int startingBase, endingBase;
    private static String inputStr;
    private static char[] convertArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
    public static void main(String[] args){
        int base10Num;
        input = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        inputStr = input.next();
 
        System.out.print("Enter starting base: ");
        startingBase = input.nextInt();
        
        base10Num = convertToBase10(inputStr, startingBase);
        
        System.out.print("Enter ending base: ");
        endingBase = input.nextInt();
        
        System.out.println("Result: " + convertToEndingBase(base10Num, endingBase));
    
    
    
    }
    
    private static int convertToBase10(String inputStr, int startingBase){
        StringBuilder sb = new StringBuilder();
        sb.append(inputStr);
        sb.reverse();
        char[] inputChars = sb.toString().toCharArray();
        
        int i = 0;
        int decNum = 0;
        
        for(char c : inputChars){
            decNum += getCharValue(c) * Math.pow(startingBase, i);
            i++;
        }
        
        return decNum;
    }
    
    private static String convertToEndingBase(int decNum, int endingBase){
        
        switch(endingBase){
            case 2:
                return Integer.toBinaryString(decNum);
            case 8:
                return Integer.toOctalString(decNum);
            case 16:
                return Integer.toHexString(decNum);
            default:
                break;
        }
        
       StringBuilder sb = new StringBuilder();
       int rem ,index = 0;
       while(decNum != 0){
           rem = decNum % endingBase;
           decNum /= endingBase;
           sb.append(getValue(rem));
       }
       
       
       
       
        return sb.reverse().toString();
    }
    
    /**
     * Returns the int value associated with the characted in a certain base.
     * @param ch
     * @return value
     */
    private static int getCharValue(char ch){
        int value = 0;
        for(char c : convertArray){
            if(c == ch){
                return value;
            }
            value++;
        }
        return value;
    }

    private static char getValue(int n) {
        for(int i = 0; i < convertArray.length; i++){
            if(n == i){
                return convertArray[i];
            }
        }
        return ' ';
    }
}   
    

