package CSE114_Homework7;

import java.util.ArrayList;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #7
 */
public class DessertCafe {
    public static void main(String[] args){
        ArrayList<Dessert> dessertMenu = new ArrayList<>();
        
        Cake cake1 = new Cake(3);
        Cake cake2 = new Cake(5);
        
        CookiePack cookies1 = new CookiePack(5, 1);
        CookiePack cookies2 = new CookiePack(3,2);
        
        IceCream iceCream1 = new IceCream(4);
        IceCream iceCream2 = new IceCream(5);
        
        Sundae sundae1 = new Sundae(5, 2);
        Sundae sundae2 = new Sundae(4, 2);
        
        dessertMenu.add(cake1);
        dessertMenu.add(cake2);
        dessertMenu.add(cookies1);
        dessertMenu.add(cookies2);
        dessertMenu.add(iceCream1);
        dessertMenu.add(iceCream2);
        dessertMenu.add(sundae1);
        dessertMenu.add(sundae2);
        
        // The get name and get cost methods are being called by the toString method
        for(Dessert dessert : dessertMenu){
            System.out.println(dessert.toString());
        }

    }
}
