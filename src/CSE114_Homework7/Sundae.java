
package CSE114_Homework7;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #7
 */
class Sundae extends IceCream {
    private int toppingsCost;
    
    public Sundae(int iceCreamCost, int toppingsCost) {
        super(iceCreamCost);
        this.name = "Sundae";
        this.toppingsCost = toppingsCost;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCost() {
        return super.getCost() + toppingsCost;
    }
    
    @Override
    public String toString(){
        return this.name + ": $" + this.getCost();
    }
    
    @Override
    public boolean equals(Object obj){
        return (obj instanceof Sundae) 
                && (this.name.equals(((Sundae)obj).getName())) 
                && (this.getCost() == ((Sundae)obj).getCost());
    }
}
