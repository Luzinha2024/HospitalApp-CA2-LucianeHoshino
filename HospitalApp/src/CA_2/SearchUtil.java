/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CA_2;
import java.util.List;

/**
 *
 * @author lucia
 */
           // Define the SearchUtil class, which provides search-related utility methods
public class SearchUtil {
               
    // Define a public static method called sequentialSearch that takes a list of Employee objects 
    // and a searchName string, and returns the Employee if found (or null if not found)
    public static Employee sequentialSearch(List<Employee> employeeList, String searchName) {
        
        // Loop through each Employee object in the provided employeeList
        for (Employee employee : employeeList) {
            
            // Check if the current employee's name matches the searchName (ignoring case)
            if (employee.getName().equalsIgnoreCase(searchName)) {
                
                // If a match is found, return the matching Employee object
                return employee;
            }
        }
        
        // If no match is found after looping through the list, return null
        return null;
    }
}