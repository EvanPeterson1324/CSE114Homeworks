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
    
    /**
     * Adds a repair ticket to the specified car; returns -1 if the car isn't found.
     * @param vin
     * @param cost
     * @param description
     * @return 
     */
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
    
    /**
     * Gets the cost of the repair given a ticket number; returns -1.0 if the ticketNum isn't found.
     * @param ticketNum
     * @return 
     */
    public double getRepairCost(int ticketNum) {
        RepairTicket ticket = findTicketNumber(ticketNum);
        if(ticket != null){
            return ticket.getCost();
        }
        
        return -1.0;
    }
    
    /**
     * Gets the total cost of repairs for a car given its VIN number; returns -1.0 otherwise.
     * @param vin
     * @return 
     */
    public double getTotalRepairCosts(String vin) {
        Car car = searchForCarByVin(vin);
        double totalCost = 0;
        if(car != null){
            for(RepairTicket ticket : car.getRepairTickets()){
                totalCost += ticket.getCost();
            }
            return totalCost;
        }
        return -1.0;
    }
    
    /**
     * Searches for the car make with the most tickets in the database and returns the name of that make; 
     * returns null otherwise.
     * @return 
     */
    public String getWorstCarMake() {
        // If there are no cars in the database, return null.
        if(carRepairShopDatabase[0] == null){
            return null;
        }
        
        Car bigBoy = carRepairShopDatabase[0];
        
        for(Car car : carRepairShopDatabase){
            if(bigBoy.getRepairTickets().length < car.getRepairTickets().length){
                bigBoy = car;
            }
        }
        return bigBoy.getMake();
    }
    
    /**
     * Updates the cost of a repair given a ticket number and a new cost; return false if the ticket is not found.
     * @param ticketNum
     * @param newCost
     * @return 
     */
    public boolean updateRepairCost(int ticketNum, double newCost) {
        RepairTicket ticket = findTicketNumber(ticketNum);
        if(ticket != null){
            ticket.setCost(newCost);
            return true;
        }
        return false;
    }
    
    public boolean deleteRepair(int ticketNum) {
        for(Car car: carRepairShopDatabase){
            RepairTicket[] tempTickets = car.getRepairTickets();
            for(int i = 0; i < tempTickets.length; i++){
                if(tempTickets[i].getTicketNum() == ticketNum){
                    tempTickets[i] = null;
                    shiftTicketsLeftFromIndex(i, tempTickets);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteAllRepairsForCar(String VIN) {
        Car car = searchForCarByVin(VIN);
        if(car != null){
            car.deleteAllRepairs();
            return true;
        }
        return false;
    }
    
    public boolean deleteCarAndRepairs(String VIN) {
        
        if(searchForCarByVin(VIN) != null){
            int index = getIndexInDatabase(VIN);
            carRepairShopDatabase[index] = null;
            shiftCarsLeftFromIndex(index);
            return true;
        }
        return false;
    }
    
    /**
     * Finds the ticket corresponding with the given ticket Number and returns the RepairTicket.
     * @param ticketNum
     * @return 
     */
    private RepairTicket findTicketNumber(int ticketNum){
        for(Car car: carRepairShopDatabase){
            for(RepairTicket ticket : car.getRepairTickets()){
                if(ticket.getTicketNum() == ticketNum){
                    return ticket;
                }
            }
        }
        
        return null;
    }
    
    /** 
     * This method returns the index of the car with the sent in VIN number; returns -1 if the car isn't found.
     * @param VIN
     * @return 
     */
    private int getIndexInDatabase(String VIN){
        for(int i = 0; i < carRepairShopDatabase.length; i++){
            if(carRepairShopDatabase[i].getVin().equalsIgnoreCase(VIN)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Shifts the elements in the database to the left to fill the gaps left by removing cars.
     * @param index 
     */
    private void shiftCarsLeftFromIndex(int index){
        for(int i = index; i < carRepairShopDatabase.length - 1; i++){
            carRepairShopDatabase[i] = carRepairShopDatabase[i+1];
        }
    }
    
    private void shiftTicketsLeftFromIndex(int index, RepairTicket[] tickets){
        for(int i = index; i < tickets.length - 1; i++){
            tickets[i] = tickets[i+1];
        }
    }

}
