package com.amritaDeviayuTunjungbiruJSleepDN;
import java.util.*;
import java.io.*;

/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (11-10-2022)
 */
public class Algorithm {
    private Algorithm() {
    }

    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        ArrayList<T> list = new ArrayList<>();
        while(iterator.hasNext()) {
            if(pred.predicate(iterator.next())) {
                list.add(iterator.next());
            }
        }
        return list;
    }

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
            if(pred.predicate(iterator.next())) {
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
            if(pred.predicate(iterator.next())) {
                return iterator.next();
            }
        }
        return null;
    }

    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return paginate(iterator, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return paginate(it, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);
        // skip first occurrences of element
        while (iterator.hasNext() && occurences < startingIdx) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                ++occurences;
        }
        // get the next occurrences of element
        while (iterator.hasNext() && pageList.size() < pageSize) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                pageList.add(obj);
        }
        return pageList;
    }
}