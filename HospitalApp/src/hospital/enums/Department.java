/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospital.enums;

/**
 *
 * @author lucia
 */
    public enum Department {
  
       // Each department type has a custom label for better display
       EMERGENCY("Emergency Department"),        // Department handling urgent medical cases
       TECH_SUPPORT("Technical Support"),         // Department responsible for technical assistance
       HR("Human Resources"),                     // Department managing employee relations
       PHYSIOTHERAPY("Physiotherapy Department"); // Department focused on physical rehabilitation
    
   private final String label; // This variable stores the friendly label for each manager type

    Department(String label) { // Constructor: receives the label and stores it in the 'label' variable
        this.label = label;// Assigns the label to each enum value
    }

    @Override // Overrides the default toString() method to return the friendly label
public String toString() {
        return label;// So when printed, it shows "Team Lead" instead of TEAM_LEAD
    }
}