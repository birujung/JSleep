package com.amritaDeviayuTunjungbiruJSleepDN.dbjson;

import java.util.HashMap;

/**
 * A base class for objects that can be serialized and assigned an ID.
 *
 * <p>This class provides an ID field and a simple mechanism for assigning unique IDs to objects of subclasses.
 * It also provides methods for comparing objects by ID and for managing the ID counter for each subclass.</p>
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version 1.0
 * @since 11 October 2022
 */
public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    /**
     * Construct a new `Serializable` object and assign it a unique ID.
     *
     * This constructor creates a new `Serializable` object and assigns it an ID based on the ID counter for its class.
     * If this is the first object of its class to be constructed, its ID will be 1.
     * Otherwise, it will be one greater than the ID of the previous object of the same class.
     *
     * @see #mapCounter
     */

    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if(counter == null) {
            counter = 0;
        } else {
            counter += 1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public boolean equals(Object lain) {
        return lain instanceof Serializable && ((Serializable)lain).id == this.id;
    }

    protected boolean equals(Serializable lain) {
        return lain.id == this.id;
    }

    public static <T extends Serializable> Integer getClosingId(Class<T> kelas) {
        return mapCounter.get(kelas);
    }

    public static <T> Integer setClosingId(Class<T> kelas, int id) {
        return mapCounter.put(kelas, id);
    }

    public int compareTo(Serializable lain) {
        return Integer.compare(this.id, lain.id);
    }
}
