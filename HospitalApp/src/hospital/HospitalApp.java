/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

import hospital.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author lucia
 */
         public class HospitalApp {

             private static List<Employee> people = new ArrayList<>();
             private static final Scanner scanner = new Scanner(System.in);
         
         public static void main(String[] args) {
             
              while (true) {
            System.out.println("\nPlease select an option:");
            for (hospital.enums.MenuOption option : hospital.enums.MenuOption.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option);
 
            }

            
    }
         }
           }
        