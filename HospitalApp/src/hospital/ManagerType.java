/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospital;

/**
 *
 * @author lucia
 */
public enum ManagerType {// Enum that represents the different types of managers in the system

      // Each manager type has a custom label to display nicely in the system

    HEAD_MANAGER("Head Manager"),                               // Type 1: Head of department
    ASSISTANT_MANAGER("Assistant Manager"),                     // Type 2: Supports the head manager
    TEAM_LEAD("Team Lead"),                                     // Type 3: Leads a smaller team
    CHIEF_EXECUTIVE_OFFICER_CEO("Chief Executive Officer (CEO)"); // Type 4: Highest-level manager

private final String label; // This variable stores the friendly label for each manager type

    ManagerType(String label) { // Constructor: receives the label and stores it in the 'label' variable
        this.label = label;// Assigns the label to each enum value
    }

    @Override // Overrides the default toString() method to return the friendly label
public String toString() {
        return label;// So when printed, it shows "Team Lead" instead of TEAM_LEAD
    }
}