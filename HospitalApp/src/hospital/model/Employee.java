/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospital.model;
import hospital.enums.Department;
import hospital.enums.ManagerType;
/**
 *
 * @author lucia
 */
    
    public class Employee extends Person {
    private ManagerType managerType;
    private Department department;

    public Employee(String name, ManagerType managerType, Department department) {
        super(name);
        this.managerType = managerType;
        this.department = department;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return getName() + " - " + managerType + " - " + department;
    }
}

    
    

