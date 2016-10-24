
package CSE114_Homework6;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #6
 */
public class Car {
    private String vin;
    private String make;
    private int year;
    private RepairTicket repairTickets[];
    
    public Car(String vin, String make, int year){
        this.vin = vin;
        this.make = make;
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public RepairTicket[] getRepairTickets() {
        return repairTickets;
    }

    public void addRepairTicket(RepairTicket repairTicket) {
        // Code for the expanding array
    }
    
    
    
}
