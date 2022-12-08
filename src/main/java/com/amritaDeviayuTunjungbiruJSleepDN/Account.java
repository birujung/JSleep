package com.amritaDeviayuTunjungbiruJSleepDN;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents an account for a user of the hotel booking system.
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Account extends Serializable {
    /** The name of the user associated with the account. */
    public String name;

    /** The email address of the user associated with the account. */
    public String email;

    /** The password for the account. */
    public String password;

    /** The balance of the account. */
    public double balance;

    /** The renter associated with the account. */
    public Renter renter;

    /** A regular expression that matches a valid email address. */
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";

    /** A regular expression that matches a valid password. */
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    /**
     * Constructs a new `Account` object with the given parameters.
     *
     * @param name     The name of the user associated with the account.
     * @param email    The email address of the user associated with the account.
     * @param password The password for the account.
     */
    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    /**
     * Returns a string representation of the `Account` object.
     *
     * @return a string representation of the `Account` object.
     */
    public String toString() {
        return "\nName: " + name +
                "\nEmail: " + email +
                "\nPassword: " + password +
                "\nBalance: " + balance;
    }

    /**
     * Validates the email address and password of the `Account` object.
     *
     * @return `true` if the email address and password are valid, `false` otherwise.
     */
    public boolean validate() {
        //untuk email
        Pattern patternEm = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEm = patternEm.matcher(email);
        boolean matchFoundEm = matcherEm.find();

        //untuk password
        Pattern patternPass = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPass = patternPass.matcher(password);
        boolean matchFoundPass = matcherPass.find();

        return matchFoundEm && matchFoundPass;
    }
}
