/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospital;

/**
 *
 * @author lucia
 */
       public class Validation {// Utility class that provides input validation methods.

          public static boolean isValidName(String name) {/* Method to check if a given name is valid.
                                                           * It must not be null and must contain only letters 
                                                           *(uppercase or lowercase) and spaces.*/
            
            return name != null && name.matches("[A-Za-z ]+"); /* Returns true if: // - the name is not null, and
                                                            * - it matches the regular expression "[A-Za-z ]+",
                                                            * which means the name can only include: // - uppercase letters (A-Z)
                                                            * - lowercase letters (a-z)
                                                            * - spaces
                                                            * Any digits, special characters, or empty strings will cause
                                                            *it to return false.*/
          
         
}
       }
          
    
        


          