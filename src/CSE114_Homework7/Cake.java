
package CSE114_Homework7;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #7
 */
class Cake extends Dessert{
    private int numLayers;
    private int cost;
    
    public Cake(int numLayers){
        super("Cake");
        this.numLayers = numLayers;
        this.cost = 15 + (2 * numLayers); 
    }
    
    public int getNumLayers(){
        return numLayers;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCost() {
        return this.cost;
    }
    
    @Override
    public String toString(){
        return this.name + ": $" + this.cost;
    }
    
    @Override
    public boolean equals(Object obj){
        Cake cake = (Cake) obj;
        return (this.name.equals(cake.getName()))
                && (this.numLayers == cake.getNumLayers());
    }
}
