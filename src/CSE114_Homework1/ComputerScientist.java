
package CSE114_Homework1;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #1
 */
public class ComputerScientist {
    public static void main(String[] args){
        // Print name of David Patterson
        String name = "David Patterson";
        System.out.println("Name: " + name);
        
        // Print his DoB
        String dob = "November 16th, 1947";
        System.out.println("Date of Birth: " + dob);
        
        // Print when he died, or N/A if he is alive
        String dod = "N/A";
        System.out.println("Died: " + dod);
        
        // Print his biography
        String biography = "David Andrew Patterson is an American computer pioneer and academic who has help the position of professor of \nComputer Science at the University of California since 1976."
                + "He has announced retirement in 2016 after serving nearly 40 years.\n"
                + "His books on computer architecture (co-authored with John L. Hennessy) are widely used in computer science education.\n";
        System.out.println("Biography: \n" + biography);

    }
}
