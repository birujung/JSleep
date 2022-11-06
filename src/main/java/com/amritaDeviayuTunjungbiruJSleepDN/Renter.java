package com.amritaDeviayuTunjungbiruJSleepDN;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 * @see Serializable
 */
public class Renter extends Serializable
{
    public String phoneNumber = " ";
    public String address = " ";
    public String username;
    public static final String REGEX_PHONE = "^(?:\\+?(\\d{3}))?(\\d{3})(\\d{3})(\\d{0,3}$)";
    public static final String REGEX_NAME = "[A-Za-z0-9]{4,20}";
    
    public Renter(String username, String phoneNumber, String address) {
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

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
