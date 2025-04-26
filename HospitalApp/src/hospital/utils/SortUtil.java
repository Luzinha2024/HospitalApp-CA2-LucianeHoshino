/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package hospital.utils;

import hospital.model.Person;
import java.util.List;

/**
 *
 * @author lucia
 */
public class SortUtil {
    
    
    public static void insertionSort(List<Person> list) {
    for (int i = 1; i < list.size(); i++) {
        Person key = list.get(i);
        int j = i - 1;

        while (j >= 0 && list.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
            list.set(j + 1, list.get(j));
            j = j - 1;
        }
        list.set(j + 1, key);
    }
}

}
    
    
    

