
package CSE114_Homework6;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #6
 */
public class RepairTicket {
    private String vin;
    private double cost;
    private String description;
    
    public RepairTicket(String vin, double cost, String description){
        this.vin = vin;
        this.cost = cost;
        this.description = description;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
