/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospital.utils;

/**
 *
 * @author lucia
 */
public class Validation {

public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Za-z ]+");
    }
}