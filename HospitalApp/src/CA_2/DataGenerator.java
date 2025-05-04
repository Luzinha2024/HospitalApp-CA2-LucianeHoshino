/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CA_2; // Define the package location
import java.util.List;
import java.util.Random;

/**
 *
 * @author lucia
 */
 public class DataGenerator {// Define the public class named DataGenerator
    // This method generates a random Employee using an existing list of Employee objects
 // This method generates a random Employee using an existing list of Employee objects
    public static Employee generateRandomPersonFromList(List<Employee> employeeList) {
        Random rand = new Random(); // Create a new Random object for generating random indices

        // Get a random name by selecting a random Employee and retrieving their name
        String name = employeeList.get(rand.nextInt(employeeList.size())).getName();

        // Randomly select a ManagerType from the enum values
        ManagerType manager = ManagerType.values()[rand.nextInt(ManagerType.values().length)];

        // Randomly select a Department from the enum values
        Department dept = Department.values()[rand.nextInt(Department.values().length)];

        // Create and return a new Employee object with the selected name, manager, and department
        return new Employee(name, manager, dept);
    }
 }

    