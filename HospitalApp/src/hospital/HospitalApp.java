/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

import static hospital.MenuOption.EXIT;
import static hospital.MenuOption.SAVE;
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
        public class HospitalApp {// Main class of the application, named HospitalApp

    private static List<Employee> employees = new ArrayList<>(); // Declare a static list to hold all Employee objects across the program
   
    private static final Scanner scanner = new Scanner(System.in); // Create a static scanner object to read input from the user (keyboard)

    public static void main(String[] args) {// Main method, the program’s entry point

        // Start an infinite loop to keep showing the menu until the user chooses to exit
        while (true) {
            // Display the menu header
            System.out.println("\nPLEASE SELECT AN OPTION: ");
            System.out.println("\n------------------------------\n");

            for (MenuOption option : MenuOption.values()) {// Loop through all available menu options and print them with numbers
                System.out.println(option.ordinal() + 1 + ". " + option);// Print the menu option number and label (ordinal + 1 makes it 1-based index)
            }

            int choice = -1;// Variable to store the user's menu choice

            System.out.println("\n------------------------------\n");// Draw a separator line
            System.out.print("YOUR CHOICE (1-7): ");// Prompt the user to enter a choice

            try {
                 // Read the user's input as a string
                String input = scanner.nextLine();
                // Convert the string input into an integer
                choice = Integer.parseInt(input);

                // Check if the number is outside the valid menu range
                if (choice < 1 || choice > MenuOption.values().length) {
                    System.out.println("Invalid option. Please select between 1 and " + MenuOption.values().length + ".");
                    continue;  // Go back to the menu loop
                }
           } catch (NumberFormatException e) {
                // Handle cases where the user enters something that’s not a number
                System.out.println("Invalid input. Please enter a number only.");
                continue;  // Go back to the menu loop
            }
            switch (MenuOption.values()[choice - 1]) {// Use a switch statement to handle the selected menu option
                case SORT_EMPLOYEE -> sortFromFile();  // Option: sort employees by reading from file
                case SEARCH_EMPLOYEE -> searchEmployeeByName();  // Option: search employee by name
                case ADD_EMPLOYEE -> addNewEmployee();  // Option: add a new employee manually
                case GENERATE_RANDOM_EMPLOYEE -> generateRandomEmployee();  // Option: generate a random employee
                case ALL_EMPLOYEES -> displayAllEmployees();  // Option: show all employees
                case SAVE -> saveEmployeeToFile();  // Option: save the employee list to a file
                case EXIT -> {  // Option: exit the program
                    System.out.println("Exiting...");  // Inform the user
                    return;  // Exit the main loop and end the program
                }
            }
        }
    }
    
    
    // Private method to read names from a file, assign random roles, sort, and display the top 20
    private static void sortFromFile() {
    // Ask the user to enter the file name
            System.out.print("Enter file name to read: ");
            String filename = scanner.nextLine();  // Read the file name input from the user

        try (Scanner fileScanner = new Scanner(new File(filename))) {// Clear the current employees list so we start fresh
            employees.clear();

            while (fileScanner.hasNextLine()) { // Loop through each line in the file
                String name = fileScanner.nextLine().trim();// Read and trim the name from the file
                // Randomly pick a manager type from the enum
                ManagerType manager = ManagerType.values()[new Random().nextInt(ManagerType.values().length)];
                // Randomly pick a department from the enum
                Department dept = Department.values()[new Random().nextInt(Department.values().length)];
                employees.add(new Employee(name, manager, dept));// Create a new Employee object with the name, manager, and department
            }
             // Sort the list of employees alphabetically using recursive insertion sort
        SortUtil.insertionSortRecursive(employees, employees.size());

        // Print the total number of sorted names (and limit display to top 20)
            System.out.println("Sorted Names (Top 20): " + employees.size());

        // Display up to the first 20 sorted employees
        for (int i = 0; i < Math.min(20, employees.size()); i++) {
            System.out.println((i + 1) + ". " + employees.get(i));  // Print the employee details
            System.out.println("------------------------");  // Separator line
        }
        } catch (FileNotFoundException e) {// If the file is not found, print an error message
            System.out.println("File not found!");           
        }
    }
    
    
    private static void searchEmployeeByName() {// Private method to search for an employee by name in the employees list
         // Check if the employees list is empty before searching
        if (employees.isEmpty()) {
            System.out.println("List is empty. Please sort or add employees first.");
            return;  // Exit the method early if there’s nothing to search
    }
            // Prompt the user to enter the name they want to search for
            System.out.print("Enter name to search: ");
          String name = scanner.nextLine();  // Read the user’s input for the search

        Employee found = SearchUtil.sequentialSearch(employees, name); // Call the SearchUtil class to perform a sequential (linear) search

        if (found != null) {// Check if the search found a matching employee
            System.out.println("Found: " + found);// If found, print the employee details
        } else { 
            System.out.println("Employee not found.");// If not found, inform the user
    }
        }
    
    
    private static void addNewEmployee() {// Private method to manually add a new employee by user input
           System.out.print("Enter name: ");// Prompt the user to enter the employee’s name
           String name = scanner.nextLine();// Read the name input

        if (!Validation.isValidName(name)) {// Validate the entered name using the Validation class
            System.out.println("Invalid name."); // If invalid, show an error
            return;// Exit the method without adding
        }

            System.out.println("Select Manager Type (1-4):");// Prompt the user to select a manager type
        for (int i = 0; i < ManagerType.values().length; i++) {
            System.out.println((i + 1) + ". " + ManagerType.values()[i]);// List options with numbers
        }
        int managerChoice = scanner.nextInt();// Read the selected number
        ManagerType manager = ManagerType.values()[managerChoice - 1];// Convert to the enum

             System.out.println("Select Department (1-4):");    // Prompt the user to select a department
        for (int i = 0; i < Department.values().length; i++) {
            System.out.println((i + 1) + ". " + Department.values()[i]); // List options with numbers
        }
        int deptChoice = scanner.nextInt();// Read the selected number
        scanner.nextLine(); // Clear buffer (to handle the newline)
        Department dept = Department.values()[deptChoice - 1];// Convert to the enum

        Employee newPerson = new Employee(name, manager, dept);// Create a new Employee object with the provided name, manager, and department
        employees.add(newPerson); // Add the new employee to the employees list

             System.out.println(name + " has been added as " + manager + " to " + dept + " successfully!");// Show a success message to confirm the addition
    }

    
    
    