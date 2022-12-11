package com.amritaDeviayuTunjungbiruJSleepDN;

/**
 * A functional interface that defines a method for evaluating an object and
 * returning a boolean result.
 *
 * @param <T> The type of object to be evaluated by this Predicate.
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (11-10-2022)
 */
public interface Predicate<T> {
    /**
     * Evaluates the given object and returns a boolean result.
     *
     * @param arg The object to be evaluated.
     * @return The result of the evaluation.
     */
    public abstract boolean predicate(T arg);
}
