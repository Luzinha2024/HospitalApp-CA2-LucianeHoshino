/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospital.utils;

import hospital.enums.Department;
import hospital.enums.ManagerType;
import hospital.model.Person;
import java.util.Random;

/**
 *
 * @author lucia
 */
public class DataGenerator {
    
     private static final String[] names = {"Acerola Souza", "Bruno Lucas", "Carlos Alberto", "Diana Silva", "Eva Martins", "Fábio Rocha"};
    
   public static Person generateRandomPerson() {
        Random rand = new Random();
        String name = names[rand.nextInt(names.length)];
        ManagerType manager = ManagerType.values()[rand.nextInt(ManagerType.values().length)];
        Department dept = Department.values()[rand.nextInt(Department.values().length)];
        return new Person(name, manager, dept);
    }
}