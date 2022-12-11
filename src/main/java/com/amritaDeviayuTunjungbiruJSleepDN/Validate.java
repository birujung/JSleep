package com.amritaDeviayuTunjungbiruJSleepDN;

import java.util.ArrayList;

/**
 * The `Validate` class provides a method for filtering an array of `Price` objects based on a specified value and condition.
 *
 * @author  Amrita Deviayu Tunjungbiru
 * @version 1.0
 * @since 11 December 2022
 */
public class Validate {
    /**
     * Filters an array of `Price` objects based on the specified value and condition.
     *
     * @param list  The array of `Price` objects to be filtered.
     * @param value  The value to compare against the prices in the array.
     * @param less  A boolean value indicating whether to filter prices less than or greater than the specified value.
     * @return  An `ArrayList` containing the filtered prices.
     */
    public static ArrayList filter(Price[] list, int value, boolean less) {
        ArrayList<Double> result = new ArrayList<Double>();
        for (Price price : list) {
           if (less == true && price.price <= value) {
               if (price.price <= value) {
                   result.add(price.price);
            }
            } else if(less == false && price.price > value) {
                    result.add(price.price);
            } 
        }
        return result;
    }
}
