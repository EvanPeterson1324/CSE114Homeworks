
package CSE114_Homework7;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #7
 */
class CookiePack extends Dessert{
    private int numCookies;
    private int pricePerCookie;
    private int cost;
    
    public CookiePack(int numCookies, int pricePerCookie) {
        super("Cookie Pack");
        this.numCookies = numCookies;
        this.pricePerCookie = pricePerCookie;
        cost = (numCookies * pricePerCookie);
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
        return (obj instanceof CookiePack) 
                && (this.name.equals(((CookiePack)obj).getName())) 
                && (this.cost == ((CookiePack)obj).getCost());
    }
    
}
