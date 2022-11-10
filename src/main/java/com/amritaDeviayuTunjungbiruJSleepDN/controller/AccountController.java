package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.Account;
import com.amritaDeviayuTunjungbiruJSleepDN.Algorithm;
import com.amritaDeviayuTunjungbiruJSleepDN.Renter;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class,filepath = "/Users/tunjung/coding/Java/JSleep/src/json/account.json" )
    public static JsonTable<Account> accountTable;

    public static final String REGEX_EMAIL = "^(?=.*{1,}@)[A-Za-z0-9]+@[^-][A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public static final String REGEX_PATTERN_EMAIL = null;
    public static final String REGEX_PATTERN_PASSWORD = null;

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        Account temp = Algorithm.<Account>find(accountTable,pred -> email.equals(pred.email));
        final String generatedPassword = hashPassword(password);

        if (temp != null && generatedPassword.equals(temp.password)){
            return temp;
        }else{
            return null;
        }
    }
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        //untuk email
        Pattern patternEm = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEm = patternEm.matcher(email);
        boolean matchFoundEm = matcherEm.find();

        //untuk password
        Pattern patternPass = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPass = patternPass.matcher(password);
        boolean matchFoundPass = matcherPass.find();
        Account temp = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));
        final String generatedPassword;
        if(matchFoundEm && matchFoundPass && !name.isBlank() && temp != null){
            generatedPassword = hashPassword(password);
            Account newAcc =  new Account(name,email,generatedPassword);
            accountTable.add(newAcc);
            return newAcc;
        }
        else{
            return null;
        }
    }

    @PostMapping("/{id}registerRenter")
    Renter registerRenter
            (
                    @PathVariable int id,
                    @RequestParam String username,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            ) {
        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    @PostMapping("/{id}topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance) {
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }

    String hashPassword(String password){
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
        return generatedPassword;
    }
}