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

public static void quickSort(List<Person> list, int low, int high) {
    if (low < high) {
        int pi = partition(list, low, high);
        quickSort(list, low, pi - 1);
        quickSort(list, pi + 1, high);
    }
}

private static int partition(List<Person> list, int low, int high) {
    String pivot = list.get(high).getName();
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (list.get(j).getName().compareToIgnoreCase(pivot) <= 0) {
            i++;
            Person temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
    Person temp = list.get(i + 1);
    list.set(i + 1, list.get(high));
    list.set(high, temp);
    return i + 1;
}
  }
