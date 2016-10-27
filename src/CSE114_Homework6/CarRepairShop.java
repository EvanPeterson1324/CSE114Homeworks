package CSE114_Homework6;

/**
 * @author Evan Peterson 
 * SBU ID: 108509452 
 * CSE 114 
 * Homework #6
 */
public class CarRepairShop {

    private Car[] carRepairShopDatabase;
    private CarMake[] carMakes;
    private int databaseSize;
    private int carMakesSize;
    public CarRepairShop() {
        carRepairShopDatabase = new Car[1];
        carMakes = new CarMake[1];
        databaseSize = 0;
        carMakesSize = 0;
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
        
        // If its a new make we will add it to the list of makes
        if(isNewMake(make)){
            if(carMakesSize == carMakes.length){
                doubleCarMakeArraySize();
            }
            carMakes[carMakesSize] = new CarMake(make, 0);
            carMakesSize++;
        } 
        
        
        // Add the car to the database then increment the size
        carRepairShopDatabase[databaseSize] = car;
        databaseSize++;

        return databaseSize;
    }
    
    private boolean isNewMake(String make){
        for(int i = 0; i < carMakes.length; i++){
            if(carMakes[i] != null && carMakes[i].getName().equalsIgnoreCase(make)){
                return false;
            }
        }
        return true;
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
     * Doubles the size of an array by creating a new one, adding the elements
     * from the old one, and then setting the reference of the old one to the
     * new one.
     */
    private void doubleCarMakeArraySize() {
        CarMake[] doubledArray = new CarMake[(carMakes.length) * 2];
        for (int i = 0; i < carMakes.length; i++) {
            doubledArray[i] = carMakes[i];
        }
        carMakes = doubledArray;
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
            if(car != null && car.getVin().equalsIgnoreCase(vin)){
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
        if((car != null)){
            if((car.getRepairTickets()[0] != null)){
                for(RepairTicket ticket : car.getRepairTickets()){
                    if(ticket != null){
                        totalCost += ticket.getCost();
                    }
                }
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
        for(int i = 0; i < carRepairShopDatabase.length; i++){
            for(int j = 0; j < carMakes.length; j++){
                if(carRepairShopDatabase[i] != null && carMakes[j] != null 
                        && carRepairShopDatabase[i].getMake().equalsIgnoreCase(carMakes[j].getName())){
                    carMakes[j].addRepairs(carRepairShopDatabase[i].getNumTickets());
                }
            }
        }
        
        CarMake bigBoy = carMakes[0];
        if(bigBoy != null){
            for(int i = 0; i < carMakes.length; i++){
                if(carMakes[i] != null && bigBoy.getNumRepairs() < carMakes[i].getNumRepairs()){
                    bigBoy = carMakes[i];
                }
            }
            clearOutRepairs();
            return bigBoy.getName();
        }
        clearOutRepairs();
        return null;
    }
    
    private void clearOutRepairs(){
        for(int i = 0; i < carMakes.length; i++){
            if(carMakes[i] != null){
                carMakes[i].resetRepairs();
            }
        }
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
            if(car != null){
                RepairTicket[] tempTickets = car.getRepairTickets();
                for(int i = 0; i < tempTickets.length; i++){
                    if(tempTickets[i] != null && tempTickets[i].getTicketNum() == ticketNum){
                        tempTickets[i] = null;
                        shiftTicketsLeftFromIndex(i, tempTickets);
                        car.decreaseNumTickets();
                        return true;
                    }
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
            databaseSize--;
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
            if(car != null){
                for(RepairTicket ticket : car.getRepairTickets()){
                    if((ticket != null) && (ticket.getTicketNum() == ticketNum)){
                        return ticket;
                    }
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
            carRepairShopDatabase[i+1] = null;
        }
    }
    
    private void shiftTicketsLeftFromIndex(int index, RepairTicket[] tickets){
        for(int i = index; i < tickets.length - 1; i++){
            tickets[i] = tickets[i+1];
            tickets[i+1] = null;
        }
    }

}
