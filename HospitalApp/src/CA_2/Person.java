/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CA_2;


/**
 *
 * @author lucia
 */
    // Define the Person class, which serves as the base class (superclass) for shared attributes
public class Person {
    
    // Declare a public instance variable to store the person's name
    public String name;

    // Constructor: initializes a new Person object with the given name
    public Person(String name) {
        this.name = name; // Assign the provided name to the instance variable
    }

    // Getter method: returns the person's name
    public String getName() {
        return name;
    }

    // Override the default toString() method to return just the name when printing the object
    @Override
    public String toString() {
        return name;
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /*private String name;
    private ManagerType managerType;
    private Department department;

    public Person(String name, ManagerType managerType, Department department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " - " + managerType + " - " + department;
    }
}*/