package CSE114_Homework1;

/**
 * @author Evan Peterson 
 * SBU ID: 108509452 
 * CSE 114 
 * Homework #1
 */
public class Schedule {
    
    // Main Method
    public static void main(String[] args) {
        // Name on first line
        System.out.println("This is Evan Peterson's Schedule");

        // SBU ID on second line
        System.out.println("SBU ID: 108509452");

        // Displays the Schedule
        displaySchedule();
    }

    // Method which sets up the schedule format
    private static void displaySchedule() {
        // To hold the strings
        String[][] scheduleFormat = new String[11][6];
        
        // Setting up the days
        scheduleFormat[0][1] = "                     Monday     ";
        scheduleFormat[0][2] = "Tuesday     ";
        scheduleFormat[0][3] = "Wednesday     ";
        scheduleFormat[0][4] = "Thursday     ";
        scheduleFormat[0][5] = "Friday";
        
        // Setting up the times
        scheduleFormat[1][0] = "8:00 am - 8:53 am ";
        scheduleFormat[2][0] = "9:00 am - 10:00 am ";
        scheduleFormat[3][0] = "10:00 am - 11:00 am ";
        scheduleFormat[4][0] = "11:00 am - 12:00 pm ";
        scheduleFormat[5][0] = "12:00 pm - 1:00 pm ";
        scheduleFormat[6][0] = "1:00 pm - 2:20 pm ";
        scheduleFormat[7][0] = "2:30 pm - 3:50 pm ";
        scheduleFormat[8][0] = "4:00 pm - 5:20 pm ";
        scheduleFormat[9][0] = "5:30 pm - 6:50 pm ";
        scheduleFormat[10][0] = "7:00 pm - 8:20 pm ";
        
        // Setting up the classes(5 classes listed)
        scheduleFormat[1][1] = "   PHY 125 ";
        scheduleFormat[1][3] = "               PHY 125 ";
        scheduleFormat[1][5] = "                   PHY 125 ";
        
        scheduleFormat[3][1] = " CSE 873 ";
        
        scheduleFormat[6][1] = "   CSE 352 ";
        scheduleFormat[6][3] = "               CSE 352 ";
        
        scheduleFormat[7][1] = "   CSE 114 ";
        scheduleFormat[7][3] = "               CSE 114 ";
        
        scheduleFormat[9][1] = "   AMS 310 ";
        scheduleFormat[9][3] = "               AMS 310 ";
        
      
        
        // To iterate through the rows and columns
        for (String[] rows : scheduleFormat) {
            System.out.print("");
            for (String str : rows) {
                
                // Setting null values to non-null values in the multi dim array.
                if (str == null) {
                    str = "";
                }
                System.out.print(str);
            }
            System.out.println();
        }
    }

}
