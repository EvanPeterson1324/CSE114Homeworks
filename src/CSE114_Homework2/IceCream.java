package CSE114_Homework2;

//package CSE114_HW2;

import java.util.Scanner;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #2
 */
public class IceCream {
    private static final String RADIUS_PROMPT = "Enter radius of ice cream and cone (in inches): ";
    private static final String HEIGHT_PROMPT = "Enter height of cone (in inches): ";
    private static final String VOLUME_PROMPT = "Volume of ice cream (in cubic inches): ";
    private static final double PI = 3.14;
    
    public static void main(String[] args){
        
        // Scanner to read in input from the user
        Scanner input = new Scanner(System.in);
        
        // Prompt the user for a radius of the cone
        System.out.print(RADIUS_PROMPT);
        String coneRadius = input.next();
        System.out.println();
        
        // Prompt the user for a height of the cone
        System.out.print(HEIGHT_PROMPT);
        String coneHeight = input.next();
        System.out.println();
        
        // Display the volume of the Ice Cream
        System.out.println(VOLUME_PROMPT + calculateVolume(coneRadius, coneHeight));
        
    }
    
    /**
     * This method calculates the volume of half the sphere added with the volume of the cone.
     * @param radiusStr
     * @param heightStr
     * @return 
     */
    private static double calculateVolume(String radiusStr, String heightStr){
        
        double radius = Double.parseDouble(radiusStr);
        double height = Double.parseDouble(heightStr);
        
        // Cone Volume = (3.14 * radius^2 * height) / 3
        double volume = (PI * (Math.pow(radius, 2)) * height) / 3;
        // Sphere Volume = (4 * 3.14 * r^3) / 3
        double halfSphereVolume = ((4 * PI * (Math.pow(radius, 3))) / 3 ) / 2;
        
        return (volume + halfSphereVolume);
    }
}
