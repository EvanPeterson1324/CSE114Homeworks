package CSE114_Homework5;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;

/**
 *
 * @author evanpeterson
 */
public class Homework5Methods {
    // part 1

    public static String eliminateDuplicates(String str) {
        // LinkedHashSet maintains the order while not allowing for duplicates.
        // This is different then a HashSet because the HashSet doesnt maintain order. (This makes it faster)
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            charSet.add(ch);
        }
        for (char ch : charSet) {
            sb.append(ch);
        }
        return sb.toString();
    }

    // part 2
    public static String getDigits(String phoneNumber) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.charAt(i) != '-') {
                sb.append(Character.toLowerCase(phoneNumber.charAt(i)));
            }
        }
        
        StringBuilder sb2 = new StringBuilder();
        String noHyphenStr = sb.toString();
        
        // Now we have the string builder with no Hyphens
        for(int i = 0; i < noHyphenStr.length(); i++){
            if(Character.isDigit(noHyphenStr.charAt(i))){
                sb2.append(noHyphenStr.charAt(i));
            } else {
                char convertedChar = convertCharToDialDigit(noHyphenStr.charAt(i)).charAt(0);
                sb2.append(convertedChar);
            }
        }
 
        return sb2.toString();
    }
    
    private static String convertCharToDialDigit(char ch){
        char[][] dialNumbers = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}   
        };
        
        for(int i = 0; i < dialNumbers.length; i++){
            for(int j = 0; j < dialNumbers[i].length; j++){
                if(ch == dialNumbers[i][j]){
                    return  i + "";
                }
            }
        }
        return "";   
    }

    // part 3
    public static int lowestBasePalindrome(int num) {
        // fill this in
        return 0;
    }

    // part 4
    public static int[] interleaveArrays(int[] array1, int[] array2, int stride, int maxElements) {
        // Check if stride or max elements are <= 0
        if(stride <= 0 || maxElements <= 0){
            return null;
        }
        
        Stack interStack = new Stack();
        int arr1Pos = 0;
        int arr2Pos = 0;
        
        // Loop until the stack reaches size of maxElements
        while(interStack.size() < maxElements){
            
            // Take stride number of elements from array 1
            for(int i = 0; i < stride; i++){
                // If we reach the max elements then we just return the interleaved array
                if(interStack.size() == maxElements){
                   return popFromStackAndMakeArray(interStack);  
                }
                
                // Push the next int from array 1 onto the stack if the pointer > array1.length
                if(arr1Pos < array1.length){
                    interStack.push(array1[arr1Pos]);
                    arr1Pos++;
                } else{
                    return pushRestOfArray2AndMakeArray(interStack, array2, arr2Pos, maxElements);   // Else we just push elements from array2 until we reach maxElements or arr2 runs out
                }
            }
            
            
            // Take stride number of elements from array 2
            for(int i = 0; i < stride; i++){
                // If we reach the max elements then we just return the interleaved array
                if(interStack.size() == maxElements){
                   return popFromStackAndMakeArray(interStack);  
                }
                
                // Push the next int from array 2 onto the stack if the pointer > array2.length
                if(arr2Pos < array2.length){
                    interStack.push(array2[arr2Pos]);
                    arr2Pos++;
                } else{
                    return pushRestOfArray1AndMakeArray(interStack, array1, arr1Pos, maxElements);   // Else we just push elements from array1 until we reach maxElements or arr1 runs out
                }
            }
        }
        return null;
    }
    
    private static int[] popFromStackAndMakeArray(Stack interStack){
        int[] array3 = new int[interStack.size()];
        for(int i = array3.length - 1; i <= 0; i--){
            array3[i] = (int) interStack.pop();
        }
        return array3;
    }
    
    private static int[] pushRestOfArray1AndMakeArray(Stack interStack, int[] array1, int arr1Pos, int maxElements){
        
        while((interStack.size() < maxElements) && (arr1Pos < array1.length)){
            interStack.push(array1[arr1Pos]);
            arr1Pos++;
        }
        
        int[] array3 = new int[interStack.size()];
        int i = array3.length - 1;
        
        while(!interStack.isEmpty()){
            array3[i] = (int) interStack.pop();
            i--;
        }
        
        return array3;
    }
    
    private static int[] pushRestOfArray2AndMakeArray(Stack interStack, int[] array2, int arr2Pos, int maxElements){

        while((interStack.size() < maxElements) && (arr2Pos < array2.length)){
            interStack.push(array2[arr2Pos]);
            arr2Pos++;
        }
        
        int[] array3 = new int[interStack.size()];
        int i = array3.length - 1;
        while(!interStack.isEmpty()){
            array3[i] = (int) interStack.pop();
            i--;
        }
        return array3;
    }

    // Part 5
    public static void rotateRight(int[][] matrix, int numCols) {
        if(numCols > 0){
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < numCols; j++){
                     rotateRight1DArray(matrix[i]);
                }
            } 
        }  
    }

    private static void rotateRight1DArray(int[] a){
        int temp = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            a[i + 1] = a[i]; 
        }
        a[0] = temp;
        
    }
    
}
