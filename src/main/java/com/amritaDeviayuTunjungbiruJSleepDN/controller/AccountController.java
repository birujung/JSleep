package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.*;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The AccountController class provides methods to handle requests for accounts, such as logging in, registering,
 * and adding a renter to an account.
 *
 * <p>It implements the {@link BasicGetController} interface and uses a JsonTable of Account objects to store
 * account information.</p>
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @see Account
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    /**
     * REGEX for the email. Email should be in the format of local@domain, example : amandio@gmail.com
     * local only contains alphanumeric characters and can't contain
     * any special characters or whitespace. domain can't contain any number.
     */
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z.]+\\.[a-zA-Z]+?$";

    /**
     * REGEX for the password. Password should be at least 8 characters long and contain at least 1 uppercase letter,
     * 1 lowercase letter, 1 number, and no whitespace.
     */
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    /**
     * Pattern for email REGEX.
     */
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    /**
     * Pattern for password REGEX.
     */
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    /**
     * A `JsonTable` that stores account data.
     *
     * @JsonAutowired indicates that this field should be initialized with data from the specified file.
     */
    @JsonAutowired(value = Account.class,filepath = "/Users/tunjung/coding/Java/JSleep/src/json/account.json")
    public static JsonTable<Account> accountTable;

    /**
     * Attempts to log in to the system using the registered email and password.
     *
     * @param email The email of the account.
     * @param password The password of the account.
     * @return The account object if the login is successful, or `null` otherwise.
     */
    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

        final String generatedPassword = hashPassword(password);

        if (findAccount != null && generatedPassword.equals(findAccount.password)){
            return findAccount;
        }else{
            return null;
        }
    }

    /**
     * Register a new account to the system using the name, email and password.
     *
     * @param name The name the user wants to register.
     * @param email The email of the account.
     * @param password The password of the account.
     * @return The created `Account` object if the registration is successful, or `null` otherwise.
     */
    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){

        Matcher matcherEmail = REGEX_PATTERN_EMAIL.matcher(email);
        boolean matchEmail = matcherEmail.find();

        Matcher matcherPassword = REGEX_PATTERN_PASSWORD.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();

        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

        if (findAccount == null && matchEmail && matchFoundPassword) {
            final String generatedPassword;
            generatedPassword = hashPassword(password);
            Account account = new Account(name, email, generatedPassword);
            accountTable.add(account);
            return account;
        } return null;

    }

    /**
     * Registers a new renter for the specified account.
     *
     *  @param id The ID of the account.
     *  @param username The username of the renter.
     *  @param address The address of the renter.
     *  @param phoneNumber The phone number of the renter.
     *  @return The created `Renter` object if the registration is successful, or `null` otherwise.
     */
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id,
                          @RequestParam String username,
                          @RequestParam String address,
                          @RequestParam String phoneNumber ){

        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, phoneNumber, address);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    /**
     * Adds the specified amount to the balance of the specified account.
     *
     * @param id The ID of the account.
     * @param balance The amount to add to the balance of the account.
     * @return `true` if the balance was successfully updated, or `false` otherwise.
     */
    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id,
                  @RequestParam double balance ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Hashes the provided password using the MD5 algorithm.
     *
     * @param password The password to hash.
     * @return The hashed password.
     */
    String hashPassword(String password){
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /**
     * Returns the `JsonTable` object that stores the accounts.
     *
     * @return The `JsonTable` object that stores the accounts.
     */
    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
}