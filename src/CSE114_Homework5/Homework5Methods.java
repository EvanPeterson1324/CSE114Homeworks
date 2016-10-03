package CSE114_Homework5;

import java.util.HashSet;
import java.util.LinkedHashSet;

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
		for(char ch : str.toCharArray()){
                    charSet.add(ch);
                }
                for(char ch : charSet){
                    sb.append(ch);
                }
		return sb.toString();
	}

	// part 2
	public static String getDigits(String phoneNumber) {
		// fill this in
		return "";
	}

	// part 3
	public static int lowestBasePalindrome(int num) {
		// fill this in
		return 0;
	}

	// part 4
	public static int[] interleaveArrays(int[] array1, int[] array2, int stride, int maxElements) {
		return null;
	}
	
	// part 5
	public static void rotateRight(int[][] matrix, int numCols) {
		// fill this in
	}	
}
