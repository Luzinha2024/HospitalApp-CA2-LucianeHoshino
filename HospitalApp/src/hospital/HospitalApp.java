/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

import hospital.enums.MenuOption;
import static hospital.enums.MenuOption.EXIT;
import static hospital.enums.MenuOption.SAVE;
import hospital.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author lucia
 */
         public class HospitalApp {

             private static List<Employee> people = new ArrayList<>();
             private static final Scanner scanner = new Scanner(System.in);
         
         public static void main(String[] args) {
             
              while (true) {
            System.out.println("\nPlease select an option:");
            for (hospital.enums.MenuOption option : hospital.enums.MenuOption.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option);
            }
              int choice = -1;
         try {
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
         
}       catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue; // Go back to start to while
}
        if (choice < 1 || choice > MenuOption.values().length) {
          System.out.println("Invalid option. Please select between 1 and " + MenuOption.values().length + ".");
         continue;
}
        if (choice < 1 || choice > MenuOption.values().length) {
          System.out.println("Invalid option. Please select between 1 and " + MenuOption.values().length + ".");
         continue;
}

            switch (hospital.enums.MenuOption.values()[choice - 1]) {
                case SORT_EMPLOYEE -> sortFromFile();
                case SEARCH_EMPLOYEE -> searchByName();
                case ADD_EMPLOYEE -> addNewPerson();
                case GENERATE_RANDOM_EMPLOYEE -> generateRandomEmployee();
                case ALL_EMPLOYEES -> displayAllEmployees();              
                case SAVE -> savePeopleToFile();              
                case EXIT -> {
                    System.out.println("Exiting...");
                    return;
                }
            }
        }

        }
            
    }
         
           
        