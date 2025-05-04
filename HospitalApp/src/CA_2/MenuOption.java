/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CA_2;

/**
 *
 * @author lucia
 */
public enum MenuOption {// Each item below is a menu option with a friendly display label
    
    // Option 1: sort the employee list
    SORT_EMPLOYEE("Sort Employees"),              // Option 1: sort the employee list
    SEARCH_EMPLOYEE("Search by Employee Name"),            // Option 2: search an employee by name
    ADD_EMPLOYEE("Add Employee"),                 // Option 3: manually add an employee
    GENERATE_RANDOM_EMPLOYEE("Generate Random Employees"),  // Option 4: create a random employee
    ALL_EMPLOYEES("Show All Employee"),                    // Option 5: show all employees
    SAVE("Save to File"),                         // Option 6: save the list to a file
    EXIT("Exit");                                 // Option 7: exit the menu

    private final String label; // A variable to store the display label for each option

    MenuOption(String label) {  // Constructor for the enum: receives and stores the label for each option
        this.label = label;// Set the label to the value passed when defining the option
    }

    @Override // Overrides toString() so that the label is shown when we print the option
    public String toString() {
        return label;// This is what gets printed in the menu (instead of SORT_EMPLOYEE)
    }
}