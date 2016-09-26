/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE114_Homework4;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #4
 */
public class RunLengthEncoding {
    private static Stack encodeStack = new Stack();
    private static String inputStr, flagStr, encodedStr;
    private static Scanner input;
    public static void main(String[] args){
        input = new Scanner(System.in);
        System.out.print("Enter input string: ");
        inputStr = input.next();
        if(!areValidChars(inputStr)){
            System.out.println("Bad Input.");
            System.exit(0);
        }
        
        System.out.print("Enter flag character: ");
        flagStr = input.next();
        if(!isValidFlag(flagStr)){
            System.out.println("Bad Input.");
            System.exit(0);
        }
        
        encodedStr = encodeString(inputStr, flagStr);
        System.out.println("Encoded: " + encodedStr);
    }
    
    
    private static boolean areValidChars(String inputStr){
        for(char c : inputStr.toCharArray()){
            if(!Character.isLetter(c) || !Character.isUpperCase(c)){
                return false;
            }
        }
        return true;
    }
    
    private static boolean isValidFlag(String flag){
        return ( flag.equals("#") 
                || flag.equals("$") 
                || flag.equals("&") 
                || flag.equals("*") );
    }

    private static String encodeString(String inputStr, String flagStr) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : inputStr.toCharArray()){
            if(encodeStack.isEmpty()){
                encodeStack.push(ch);
            }else if(encodeStack.peek().equals(ch)){
                    encodeStack.push(ch);
            } else{
                if(encodeStack.size() <= 3){
                    while(!encodeStack.isEmpty()){
                        sb.append(encodeStack.pop());
                    }
                    encodeStack.clear();
                    encodeStack.push(ch);
                }else{
                    sb.append(flagStr).append(encodeStack.peek()).append(encodeStack.size());
                    encodeStack.clear();
                    encodeStack.push(ch);
                }
            }
        }
            if(encodeStack.size() <= 3){
                while(!encodeStack.isEmpty()){
                    sb.append(encodeStack.pop());
                } 
            }
        return sb.toString();
    }
}
