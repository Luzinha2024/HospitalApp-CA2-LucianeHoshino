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
public class SortUtil { // Utility class that provides sorting methods for Employee lists.
    
    //Recursively sorts a list of Employee objects by name using Insertion Sort.
    public static void insertionSortRecursive(List<Employee> list, int n) {
        if (n <= 1){// Base case: if the list has 1 or fewer elements, it is already sorted
            return;
        }
         Employee last = list.get(n - 1);// Store the last element to be inserted in the correct position
         insertionSortRecursive (list, n-1);// Recursively sort the first n-1 elements
       
             int j = n-2;// Find the correct position for the 'last' element by comparing names
        
        while (j >= 0 && list.get(j).getName().compareToIgnoreCase(last.getName())> 0){
            // Shift elements that are greater than 'last' one position to the right
        list.set(j + 1, list.get(j));// Move element to the right
                    j--;// is the same j= j -1, thas mean you go step back from the list. 
        }
                
            list.set(j + 1, last);// Place the 'last' element at its correct position
        }
        
    }
    
    
    

