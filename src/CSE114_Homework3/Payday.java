
package CSE114_Homework3;

import java.util.Scanner;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #3
 */
public class Payday {

    private static final String menuPrompt = "Choose employee type: (m) manager (h) hourly (c) commission (p) pieceworker: ";
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.print(menuPrompt);
        String menuSelection = input.next().toLowerCase();

        // Checks user input for an input matching a selection
        switch (menuSelection) {
            case "m":
                managerPrompt();
                break;
            case "h":
                hourlyPrompt();
                break;
            case "c":
                commissionPrompt();
                break;
            case "p":
                pieceworkerPrompt();
                break;
            default:
                break;
        }
    }

    // Managers, who receive a fixed weekly salary;
    private static void managerPrompt() {
        double weeklySalary, grossPay = 0, taxes = 0, netPay = 0;
        
        System.out.print("Enter weekly salary: ");
        weeklySalary = input.nextDouble();
        
        System.out.println("Gross pay: " + grossPay);
        System.out.println("Taxes: " + taxes);
        System.out.println("Net Pay: " + netPay);  
    }

    /**
     * Hourly employees, who receive a fixed hourly wage for up to the first 35
     * hours they work and “double overtime” (2x their hourly wage) for overtime
     * hours worked
     */
    private static void hourlyPrompt() {
        double hourlyWage = 0, hoursWorked = 0, grossPay = 0, taxes = 0, netPay = 0;
        
        System.out.print("Enter hourly wage: ");
        hourlyWage = input.nextDouble();
        
        System.out.println("Enter hours worked: ");
        hoursWorked = input.nextDouble();
        
        System.out.println("Gross pay: " + grossPay);
        System.out.println("Taxes: " + taxes);
        System.out.println("Net Pay: " + netPay);
    }

    // Commission workers, who receive $250 plus 5.7% of their weekly sales;
    private static void commissionPrompt() {
        double weeklySalary = 0, grossPay = 0, taxes = 0, netPay = 0;
        
        System.out.print("Enter weekly sales: ");
        weeklySalary = input.nextDouble();
        
        System.out.println("Gross pay: " + grossPay);
        System.out.println("Taxes: " + taxes);
        System.out.println("Net Pay: " + netPay);
    }

    /**
     * Piece workers, who receive a fixed amount of money per item that they
     * produce (each pieceworker works on only one type of item)
     */
    private static void pieceworkerPrompt() {
        double piecesProduced = 0, payPerPiece = 0, grossPay = 0, taxes = 0, netPay = 0;
        
        System.out.print("Enter pieces produced: ");
        piecesProduced = input.nextDouble();
        
        System.out.print("Enter pay per piece: ");
        payPerPiece = input.nextDouble();
        
        System.out.println("Gross pay: " + grossPay);
        System.out.println("Taxes: " + taxes);
        System.out.println("Net Pay: " + netPay);
    }
}
