package CSE114_Homework6;

/**
 * @author Evan Peterson 
 * SBU ID: 108509452 
 * CSE 114 
 * Homework #6
 */
public class CarRepairShop {

    private Car[] carRepairShopDatabase;
    private int databaseSize;

    public CarRepairShop() {
        carRepairShopDatabase = new Car[1];
        databaseSize = 0;
    }
    
    /**
     * Adds a new car to the database with the provided VIN, make and year of manufacture
     * @param vin
     * @param make
     * @param year
     * @return int 
     */
    public int addNewCar(String vin, String make, int year) {
        // Check vin exists, if it does return -1
        if (isRepeatedVin(vin)) {
            return -1;
        }
        
        // Otherwise return the number of cars after adding the car to the database
        Car car = new Car(vin, make, year);
        if (databaseSize == carRepairShopDatabase.length) {
            doubleTheArraySize();
        }
        
        // Add the car to the database then increment the size
        carRepairShopDatabase[databaseSize] = car;
        databaseSize++;

        return databaseSize;
    }

    /**
     * Returns true if the vin number does not exist in the database.
     *
     * @param vin
     * @return boolean
     */
    private boolean isRepeatedVin(String vin) {
        for (Car car : carRepairShopDatabase) {
            if ((car != null) && (car.getVin().equalsIgnoreCase(vin))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Doubles the size of an array by creating a new one, adding the elements
     * from the old one, and then setting the reference of the old one to the
     * new one.
     */
    private void doubleTheArraySize() {
        Car[] doubledArray = new Car[(carRepairShopDatabase.length) * 2];
        for (int i = 0; i < carRepairShopDatabase.length; i++) {
            doubledArray[i] = carRepairShopDatabase[i];
        }
        carRepairShopDatabase = doubledArray;
    }

    public int addRepairTicket(String vin, double cost, String description) {
        Car foundCar = searchForCarByVin(vin);
        if(foundCar == null){
            return -1;
        }
        
        RepairTicket newTicket = new RepairTicket(vin, cost, description);
        newTicket.setTicketNum();
        foundCar.addRepairTicket(newTicket);
        return newTicket.getTicketNum();
    }
    
    /**
     * Searches the database for a car with the given vin number and 
     * returns that car reference if its found; Returns null if not found.
     * @param vin
     * @return Car
     */
    private Car searchForCarByVin(String vin){
        for(Car car : carRepairShopDatabase){
            if(car.getVin().equalsIgnoreCase(vin)){
                return car;
            }
        }
        return null;
    }

    public double getRepairCost(int ticketNum) {
        return 23.4;
    }

    public double getTotalRepairCosts(String vin) {
        return 29.12;
    }

    public String getWorstCarMake() {
        return "Go-Kart";
    }

    public boolean updateRepairCost(int ticketNum, double newCost) {
        return false;
    }

    public boolean deleteRepair(int ticketNum) {
        return false;
    }

    public boolean deleteAllRepairsForCar(String VIN) {
        return false;
    }

    public boolean deleteCarAndRepairs(String VIN) {
        return false;
    }

}
