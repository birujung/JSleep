package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.*;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class, filepath = "src\\json\\account.json")
    public static JsonTable<Account> accountTable;

    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        String generatedPassword = null;

        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        Account temp = Algorithm.<Account>find(getJsonTable(), pred -> pred.email.equals(email));
        if (temp != null && generatedPassword.equals(temp.password)) {
            return temp;
        } else {
            return null;
        }
    }

    @GetMapping
    String index() {
        return "account page";
    }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            ) {
        //untuk email
        Matcher matcherEm = REGEX_PATTERN_EMAIL.matcher(email);
        boolean matchFoundEm = matcherEm.find();

        //untuk password
        Matcher matcherPass = REGEX_PATTERN_PASSWORD.matcher(password);
        boolean matchFoundPass = matcherPass.find();

        String generatedPassword = null;
        if (matchFoundEm && matchFoundPass && !name.isBlank()) {
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] bytes = md.digest();

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                generatedPassword = sb.toString();
            }catch(NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            Account newAcc = new Account(name, email, generatedPassword);
            accountTable.add(newAcc);
            return newAcc;
        } else {
            return null;
        }
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter
            (
                    @PathVariable int id,
                    @RequestParam String username,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            ) {
        Account temp = Algorithm.<Account>find(accountTable, pred -> pred.id == id);
        if (temp.renter == null && temp != null) {
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        } else {
            return null;
        }
    }

    @PostMapping("/{id}/topUp")
    public boolean topUp(@PathVariable int id, @RequestParam double balance) {
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null) {
            account.balance += balance;
            return true;
        } else {
            return false;
        }
    }
}