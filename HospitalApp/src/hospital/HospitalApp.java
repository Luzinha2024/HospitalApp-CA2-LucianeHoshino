/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lucia
 */
public class HospitalApp {
     private static List<Person> people = new ArrayList<>();
         private static final Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         while (true) {
            System.out.println("\nPlease select an option:");
            for (hospital.enums.MenuOption option : hospital.enums.MenuOption.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option);
 
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (hospital.enums.MenuOption.values()[choice - 1]) {
                case SORT -> sortFromFile();
                case SEARCH -> searchByName();
                case ADD_RECORD -> addNewPerson();
                case SAVE -> savePeopleToFile();
                case EXIT -> {
                    System.out.println("Exiting...");
                    return;
                }
            }
        }

        }
    private static void sortFromFile() {
        System.out.print("Enter filename to read: ");
        String filename = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            people.clear();
            while (fileScanner.hasNextLine()) {
                String name = fileScanner.nextLine().trim();
                //people.add(new Person(name, ManagerType.TEAM_LEAD, Department.HR)); // Default
                hospital.enums.ManagerType manager = hospital.enums.ManagerType.values()[new Random().nextInt(hospital.enums.ManagerType.values().length)];
                hospital.enums.Department dept = hospital.enums.Department.values()[new Random().nextInt(hospital.enums.Department.values().length)];
                 people.add(new Person(name, manager, dept));

            }
            SortUtil.quickSort(people, 0, people.size() - 1);
            System.out.println("Sorted Names (Top 20):");
            people.stream().limit(20).forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static void searchByName() {
        if (people.isEmpty()) {
            System.out.println("List is empty. Sort or Add first.");
            return;
        }

        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        Person found = SearchUtil.binarySearch(people, name);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Person not found.");
        }
    }

    private static void addNewPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        if (!Validation.isValidName(name)) {
            System.out.println("Invalid name.");
            return;
        }

        System.out.println("Select Manager Type:");
        for (int i = 0; i < hospital.enums.ManagerType.values().length; i++) {
            System.out.println((i + 1) + ". " + hospital.enums.ManagerType.values()[i]);
        }
        int managerChoice = scanner.nextInt();
        hospital.enums.ManagerType manager = hospital.enums.ManagerType.values()[managerChoice - 1];

        System.out.println("Select Department:");
        for (int i = 0; i < hospital.enums.Department.values().length; i++) {
            System.out.println((i + 1) + ". " + hospital.enums.Department.values()[i]);
        }
        int deptChoice = scanner.nextInt();
        scanner.nextLine();
        hospital.enums.Department dept = hospital.enums.Department.values()[deptChoice - 1];

        Person newPerson = new Person(name, manager, dept);
        people.add(newPerson);
        System.out.println(name + " has been added as " + manager + " to " + dept + " successfully!");
    }

     private static void savePeopleToFile() {
    System.out.print("Enter filename to save (e.g., people.txt): ");
    String filename = scanner.nextLine();

    try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
        for (Person person : people) {
            writer.println(person);
            writer.println("------------------------");
        }
        System.out.println("People list saved to: " + filename);
    } catch (IOException e) {
        System.out.println("Error saving file: " + e.getMessage());
    }
}}

