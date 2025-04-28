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
import java.io.File;
import java.io.FileNotFoundException;
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
             private static List<Employee> people = new ArrayList<>();
             // Create a scanner to read user input from the terminal
             private static final Scanner scanner = new Scanner(System.in);
         
         public static void main(String[] args) {
             //This is for test
              Employee e1 = new Employee("Alice Souza", ManagerType.HEAD_MANAGER, Department.EMERGENCY);
              Employee e2 = new Employee("Carlos Almeida", ManagerType.TEAM_LEAD, Department.HR);
              Employee e3 = new Employee("Bruno de Lucas", ManagerType.CHIEF_EXECUTIVE_OFFICER_CEO, Department.PHYSIOTHERAPY);

               people.add(e1);
               people.add(e2);
               people.add(e3);
             
             // Start an infinite loop to keep showing the menu until the user chooses to exit
              while (true) {
             // Display menu options to the user    
            System.out.println("\nPlease select an option:");
            for (hospital.enums.MenuOption option : hospital.enums.MenuOption.values()) {
                // Show each option with a number (1-based index)
                System.out.println(option.ordinal() + 1 + ". " + option);
            }
              int choice = -1;// Variable to store user's choice
         try {
             // Ask user to input a number corresponding to a menu option
            System.out.print("Your choice: ");
            choice = scanner.nextInt();// Read the number
            scanner.nextLine();// Clear the newline from the input buffer
            // If user enters something that is not a number
}       catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue; // Go back to start to while
}           // If the number is not within the menu range, show error and repeat
        if (choice < 1 || choice > MenuOption.values().length) {
          System.out.println("Invalid option. Please select between 1 and " + MenuOption.values().length + ".");
         continue;
}

            // Get the selected menu option based on the user's choice (adjusted by -1)
            switch (hospital.enums.MenuOption.values()[choice - 1]) {
                // Call the appropriate method for each menu option
                case SORT_EMPLOYEE -> sortFromFile();// Sort employees from a file
                case SEARCH_EMPLOYEE -> searchByName(); // Search for an employee by name
                case ADD_EMPLOYEE -> addNewPerson();// Add a new employee manually
                case GENERATE_RANDOM_EMPLOYEE -> generateRandomEmployee();// Generate a random employee
                case ALL_EMPLOYEES -> displayAllEmployees();// Show all employees              
                case SAVE -> savePeopleToFile(); // Save the list of employees to a file              
                case EXIT -> {
                    
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
        people.clear();

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
            people.add(new Employee(name, manager, dept));
        }

        // Sort the list of employees alphabetically using recursive insertion sort
        SortUtil.insertionSortRecursive(people, people.size());

        // Show a confirmation and display the first 20 sorted employees (or fewer if less)
        System.out.println("Sorted Names (Top 20): " + people.size());
        people.stream().limit(20).forEach(System.out::println);

    }    catch (FileNotFoundException e) {
        // If the file cannot be found, show an error message
        System.out.println("File not found!");
    }
         }
          private static void searchByName() {
              // Method that allows the user to search for a person by name using binary search.
              if (people.isEmpty()) {
                 System.out.println("List is empty. Sort or Add first."); // If the list of people is empty, show a warning and exit the method.
                    return;// This prevents the binary search from running on an empty list.
        }
             // Ask the user to input the name they want to search for.
                 System.out.print("Enter name to search: ");
                 String name = scanner.nextLine();
                 
                    // Perform binary search using the name entered.
                    // The method returns a Person object if found, or null if not.
                    Person found = SearchUtil.binarySearch(people, name);  
                   // Display the result:            
              if (found != null) {
                 System.out.println("Found: " + found);// If a person was found, print their details.
        }     else {// Otherwise, show a message saying the person was not found.
                 System.out.println("Person not found.");
        }
    }

        
    
    
    
    
    
    
}
         
         
           
        