/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

import hospital.enums.Department;
import hospital.enums.ManagerType;
import hospital.enums.MenuOption;
import static hospital.enums.MenuOption.EXIT;
import static hospital.enums.MenuOption.SAVE;
import hospital.model.Employee;
import hospital.model.Person;
import hospital.utils.SearchUtil;
import hospital.utils.SortUtil;
import hospital.utils.Validation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author lucia
 */
        public class HospitalApp {
             // Create a list to store all Employee objects
             private static List<Employee> employees = new ArrayList<>();
             // Create a scanner to read user input from the terminal
             private static final Scanner scanner = new Scanner(System.in);
         
        public static void main(String[] args) {
             //This is for test
              Employee e1 = new Employee("Alice Souza", ManagerType.HEAD_MANAGER, Department.EMERGENCY);
              Employee e2 = new Employee("Carlos Almeida", ManagerType.TEAM_LEAD, Department.HR);
              Employee e3 = new Employee("Bruno de Lucas", ManagerType.CHIEF_EXECUTIVE_OFFICER_CEO, Department.PHYSIOTHERAPY);

               employees.add(e1);
               employees.add(e2);
               employees.add(e3);
             
             // Start an infinite loop to keep showing the menu until the user chooses to exit
             while (true) {
                       // Display menu options to the user    
                        System.out.println("\nPlease select an option:");
            for (hospital.enums.MenuOption option : hospital.enums.MenuOption.values()) {
                    // Show each option with a number (1-based index)
                    System.out.println(option.ordinal() + 1 + ". " + option);
            }
                 int choice = -1; // Variable to store the user's selected option, initialized to an invalid value
                 System.out.print("Your choice: "); // Prompt the user to enter a menu option

            try {
                   String input = scanner.nextLine(); //Read the user's input as a string to avoid input mismatch errors
                      choice = Integer.parseInt(input);  //Try to convert the input string to an integer

              //  Check if the entered number is within the valid range of menu options
            if (choice < 1 || choice > MenuOption.values().length) {
                         System.out.println("Invalid option. Please select between 1 and " + MenuOption.values().length + ".");
                      continue; // Restart the loop to ask the user again
    }

}           catch (NumberFormatException e) {
               //  If the input cannot be parsed as an integer (e.g., the user typed letters or symbols)
                        System.out.println("Invalid input. Please enter a number only.");
                     continue; // Restart the loop and prompt the user again
}   

            // Get the selected menu option based on the user's choice (adjusted by -1)
            switch (hospital.enums.MenuOption.values()[choice - 1]) {
                // Call the appropriate method for each menu option
                case SORT_EMPLOYEE -> sortFromFile();// Sort employees from a file
                case SEARCH_EMPLOYEE -> searchEmployeeByName(); // Search for an employee by name
                case ADD_EMPLOYEE -> addNewEmployee();// Add a new employee manually
                case GENERATE_RANDOM_EMPLOYEE -> generateRandomEmployee();// Generate a random employee
                case ALL_EMPLOYEES -> displayAllEmployees();// Show all employees              
                case SAVE -> saveEmployeeToFile(); // Save the list of employees to a file              
                case EXIT -> {//Exit the Menu
                    
                    System.out.println("Exiting...");// Exit the application
                    return;// Break the loop and end the program
                }
            }
          }
        }
        private static void sortFromFile() {
                 // Ask the user to enter the name of the file to read employee names from
                  System.out.print("Enter file name to read: ");
                   String filename = scanner.nextLine(); // Read the file name as input
             try (Scanner fileScanner = new Scanner(new File(filename))) {
                 // Clear the existing list to avoid duplicates
                  employees.clear();
                 // Read each line from the file (each line is assumed to contain a name)
            while (fileScanner.hasNextLine()) {
                     String name = fileScanner.nextLine().trim(); // Remove extra spaces
                     // Randomly assign a ManagerType from the enum
                    hospital.enums.ManagerType manager = hospital.enums.ManagerType.values()[
                     new Random().nextInt(hospital.enums.ManagerType.values().length)
            ];
                  // Randomly assign a Department from the enum
                  hospital.enums.Department dept = hospital.enums.Department.values()[
                     new Random().nextInt(hospital.enums.Department.values().length)
            ];
                   // Create a new Employee using the name, random manager, and department
                   employees.add(new Employee(name, manager, dept));
        }
                    // Sort the list of employees alphabetically using recursive insertion sort
                    SortUtil.insertionSortRecursive(employees, employees.size());
                   // Show a confirmation and display the first 20 sorted employees (or fewer if less)
                     System.out.println("Sorted Names (Top 20): " + employees.size());
                       employees.stream().limit(20).forEach(System.out::println);

    }        catch (FileNotFoundException e) {
                         // If the file cannot be found, show an error message
                        System.out.println("File not found!");
    }
         }
        private static void searchEmployeeByName() {
              // Method that allows the user to search for a person by name using binary search.
              if (employees.isEmpty()) {
                 System.out.println("List is empty. Sort or Add first."); //If the list of people is empty, show a warning and exit the method.
                    return;// This prevents the binary search from running on an empty list.
        }
             // Ask the user to input the name they want to search for.
                 System.out.print("Enter name to search: ");
                 String name = scanner.nextLine();
                 
                    // Perform binary search using the name entered.
                    // The method returns a Person object if found, or null if not.
                    Person found = SearchUtil.binarySearch(employees, name);  
                   // Display the result:            
              if (found != null) {
                 System.out.println("Found: " + found);// If a person was found, print their details.
        }     else {// Otherwise, show a message saying the person was not found.
                 System.out.println("Employee not found.");
        }
        }
        
         
          