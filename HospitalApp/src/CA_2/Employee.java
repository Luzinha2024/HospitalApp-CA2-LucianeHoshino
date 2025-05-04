/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CA_2;

/**
 *
 * @author lucia
 */
    
    // Define the Employee class, which extends (inherits from) the Person class
public class Employee extends Person {

    // Private instance variable to store the employee's manager type (uses the ManagerType enum)
    private ManagerType managerType;

    // Private instance variable to store the employee's department (uses the Department enum)
    private Department department;

    // Constructor: initializes a new Employee object with a name, manager type, and department
    public Employee(String name, ManagerType managerType, Department department) {
        super(name); // Call the constructor of the Person superclass to set the name
        this.managerType = managerType; // Set the manager type for this employee
        this.department = department;   // Set the department for this employee
    }

    // Getter method: returns the manager type of the employee
    public ManagerType getManagerType() {
        return managerType;
    }

    // Getter method: returns the department of the employee
    public Department getDepartment() {
        return department;
    }

    // Override the toString() method to return a formatted string with name, manager type, and department
    @Override
    public String toString() {
        return getName() + " - " + managerType + " - " + department;
    }
}
    

