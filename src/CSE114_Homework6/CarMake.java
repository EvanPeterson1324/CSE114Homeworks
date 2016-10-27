/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE114_Homework6;

/**
 *
 * @author Evanp
 */
public class CarMake {
    private String name;
    private int numRepairs;
    
    public CarMake(String name, int numRepairs){
        this.name = name;
        this.numRepairs = numRepairs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumRepairs() {
        return numRepairs;
    }

    public void addRepairs(int numRepairs) {
        this.numRepairs += numRepairs;
    }
    
    public void resetRepairs(){
        this.numRepairs = 0;
    }
    
    
}
