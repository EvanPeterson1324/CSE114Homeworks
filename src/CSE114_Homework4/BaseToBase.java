package CSE114_Homework4;

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
    private static char[] convertArray = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    
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
        
        
        return " ";
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
                return value + 1;
            }
            value++;
        }
        return value + 1;
    }
}





/*
Write a program that takes a positive integer expressed in one base and converts it to another. Specifically, prompt
the user to enter in the following order: (i) the input number, (ii) the base of the input number (“starting base”),
and (iii) the base that the input number will be converted into (“ending base”). You may assume that the input is
a valid integer written in the starting base. Your program must be able to handle starting and ending bases in the
range 2 through 36, inclusive.
Appendix F of the course textbook describes in detail how to convert to and from base 10. Generalize the algorithms
given there. You will find it easiest to write a program that converts the input number into decimal, and
then from decimal into the ending base. Note that for bases greater than 10 we use the letters ‘A’ through ’Z’ as
digits for representing the decimal values 10 through 35. Your program should assume that the user will enter any
input letters in uppercase only.
*/
