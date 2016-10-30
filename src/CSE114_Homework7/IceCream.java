
package CSE114_Homework7;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #7
 */
class IceCream extends Dessert{
    private int cost;
    
    public IceCream(int cost) {
        super("Ice Cream");
        this.cost = cost;
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
        IceCream iceCream = (IceCream)obj;
        return this.name.equals(iceCream.getCost()) 
                && this.cost == iceCream.getCost();
    }
}
