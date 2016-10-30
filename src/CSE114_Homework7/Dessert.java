
package CSE114_Homework7;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #7
 */
abstract class Dessert {
    String name;
    
    public Dessert(String name){
        this.name = name;
    }
    
    public abstract String getName();
    public abstract int getCost();
    
}
