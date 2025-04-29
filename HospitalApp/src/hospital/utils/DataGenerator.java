/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospital.utils;

import hospital.enums.Department;
import hospital.enums.ManagerType;
import hospital.model.Employee;
import java.util.Random;

/**
 *
 * @author lucia
 */
public class DataGenerator {
    
     private static final String[] names = {"Alice Souza", "Bruno De Lucas", "Carlos Almeida", "Diana Smith", "Eva Martins", "Fábio Martins", 
         "Gabriel Pensador", "Laura Pausine", "Marcelo Telo"};
    
   public static Employee generateRandomPerson() {
        Random rand = new Random();
        String name = names[rand.nextInt(names.length)];
        ManagerType manager = ManagerType.values()[rand.nextInt(ManagerType.values().length)];
        Department dept = Department.values()[rand.nextInt(Department.values().length)];
        return new Employee(name, manager, dept);
    }
}