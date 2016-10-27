
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
    private int repairTicketsSize;
    
    public Car(String vin, String make, int year){
        this.vin = vin;
        this.make = make;
        this.year = year;
        repairTickets = new RepairTicket[1];
        repairTicketsSize = 0;
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
    
    public int getNumTickets(){
        return repairTicketsSize;
    }
    
    /** 
     * Adds a ticket for this car instance.
     * @param repairTicket 
     */
    public void addRepairTicket(RepairTicket repairTicket) {
        // Code for the expanding array
        if (repairTicketsSize == repairTickets.length) {
            doubleTheArraySize();
        }
        
        // Add the ticket to the tickets
        repairTickets[repairTicketsSize] = repairTicket;
        repairTicketsSize++;
    }
    
    /**
     * Doubles the size of an array by creating a new one, adding the elements
     * from the old one, and then setting the reference of the old one to the
     * new one.
     */
    private void doubleTheArraySize() {
        RepairTicket[] doubledArray = new RepairTicket[(repairTickets.length) * 2];
        for (int i = 0; i < repairTickets.length; i++) {
            doubledArray[i] = repairTickets[i];
        }
        repairTickets = doubledArray;
    }

    public void deleteAllRepairs() {
        repairTickets = new RepairTicket[1];
        repairTicketsSize = 0;
    }
    
    public void decreaseNumTickets(){
        repairTicketsSize--;
    }
    
}
