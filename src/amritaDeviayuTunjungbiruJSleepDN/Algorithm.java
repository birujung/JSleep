package amritaDeviayuTunjungbiruJSleepDN;
import java.util.*;
import java.io.*;

/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (11-10-2022)
 */
public class Algorithm {
    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred  = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int temp = 0;
        while(iterator.hasNext()) {
            if(pred.predicate(iterator.next())) {
                temp++ ;
            }
        }
        return temp;
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()) {
            T current = iterator.next();
            if(pred.predicate(current)) {
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    public static <T> T find(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while(iterator.hasNext()) {
            T object = iterator.next();
            if(pred.predicate(object)) {
                return object;
            }
        }
        return null;
    }
}
