package com.amritaDeviayuTunjungbiruJSleepDN;

import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The `Renter` class represents a person who rents a room.
 *
 * @author  Amrita Deviayu Tunjungbiru
 * @version 1.0
 * @since 11 December 2022
 * @see Serializable
 */
public class Renter extends Serializable {
    /**
     *  The phone number of a renter.
     */
    public String phoneNumber = " ";

    /**
     *  The address of the renter.
     */
    public String address = " ";

    /**
     *  The username of the renter.
     */
    public String username;

    /**
     *  The regular expression pattern for validating the phone number of the renter
     */
    public static final String REGEX_PHONE = "^(?:\\+?(\\d{3}))?(\\d{3})(\\d{3})(\\d{0,3}$)";

    /**
     *  The regular expression pattern for validating the username of the renter.
     */
    public static final String REGEX_NAME = "[A-Za-z0-9]{4,20}";

    /**
     * Constructs a new `Renter` instance with the specified username, phone number, and address.
     *
     * @param username  The username of the renter.
     * @param phoneNumber  The phone number of the renter.
     * @param address  The address of the renter.
     */
    public Renter(String username, String phoneNumber, String address) {
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Validates the renter's username and phone number.
     *
     * @return `true` if the username and phone number are valid, `false` otherwise.
     */
    public boolean validate() {
        //untuk phone number
        Pattern patternNum = Pattern.compile(REGEX_PHONE);
        Matcher matcherNum = patternNum.matcher(phoneNumber);
        boolean matchFoundNum = matcherNum.find();

        //untuk username
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(username);
        boolean matchFoundName = matcherName.find();

        if (matchFoundNum && matchFoundName) {
            return true;
        } else {
            return false;
        }
    }
}
