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
public class SearchUtil {

   public static Person binarySearch(List<Person> list, String target) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Person midPerson = list.get(mid);

            int result = target.compareToIgnoreCase(midPerson.getName());

            if (result == 0) return midPerson;
            if (result < 0) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }
}