/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospital.utils;
import hospital.model.Employee;
import hospital.model.Person;
import java.util.List;

/**
 *
 * @author lucia
 */
           public class SearchUtil {// Utility class that provides search-related methods for hospital staff data.
          //Performs a binary search on a sorted list of employees to find a person by name.
           public static Person binarySearch(List<Employee> list, String target) {
               
                      int left = 0, right = list.size() - 1;// Initialize the search boundaries

              while (left <= right) {// Loop until the search range is valid
                   int mid = left + (right - left) / 2;// Calculate the middle index to avoid overflow
                    Person midPerson = list.get(mid);// Get the person at the middle index

                      int result = target.compareToIgnoreCase(midPerson.getName());// Compare the target name with the middle person's name (case-insensitive)

              if (result == 0) return midPerson;// If the names match, return the person
              if (result < 0) right = mid - 1;// If the target name comes before the middle name, search the left half
              else left = mid + 1;// If the target name comes after the middle name, search the right half
        }
                    return null;// If no match is found, return null
    }
}