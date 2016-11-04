/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSE114_Homework7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Evan Peterson SBU ID: 108509452 CSE 114 Homework #7
 */
public class ReformatCode {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid Number of Arguments");
            System.exit(0);
        }

        try (Scanner stdin = new Scanner(new File(args[0])); PrintWriter writer = new PrintWriter(new File(args[1]))) {
            while (stdin.hasNextLine()) {
                String line = stdin.nextLine(); 
                int index = line.indexOf("{");
                if (index != -1) {
                    String str = line.substring(0, index + 1);
                    writer.write(str);
                } else {
                    writer.write("\n" + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("One of the files could not be found.");
        }
    }
}
