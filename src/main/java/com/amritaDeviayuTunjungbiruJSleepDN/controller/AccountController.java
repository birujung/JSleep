package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.Account;
import com.amritaDeviayuTunjungbiruJSleepDN.Algorithm;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class,filepath = "/Users/tunjung/coding/Java/JSleep/src/main/java/com/amritaDeviayuTunjungbiruJSleepDN/dbjson/JsonAutowired" )
    public static JsonTable<Account> accountTable;

    public static final String REGEX_EMAIL = "^(?=.*{1,}@)[A-Za-z0-9]+@[^-][A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public static final String REGEX_PATTERN_EMAIL = null;
    public static final String REGEX_PATTERN_PASSWORD = null;

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }

    @PostMapping("/login")
    String login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        Account findPassword = Algorithm.<Account> find(getJsonTable(),pred -> pred.password.equals(password));
        Account findEmail = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));
        if (findPassword != null && findEmail != null){
            return email + password;
        }else {
            return null;
        }
    }
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    String register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        Account findName = Algorithm.<Account> find(getJsonTable(),pred -> pred.name.equals(name));
        Account findEmail = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));
        Account findPassword = Algorithm.<Account> find(getJsonTable(),pred -> pred.password.equals(password));
        if(findName != null && findEmail != null && findPassword != null) {
            return name + email + password;
        }else {
            return null;
        }
    }

    @PostMapping("/{id}registerRenter")
    String registerRenter
            (
                    @PathVariable int id,
                    @RequestParam String username,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            ) {
        Account account = Algorithm.<Account>find(getJsonTable(), acc -> id == acc.id);
        if (account != null){
            return id + username + address + phoneNumber;
        }else {
            return null;
        }
    }

    @PostMapping("/{id}topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance) {
        Account account = Algorithm.<Account>find(getJsonTable(), acc -> id == acc.id);
        if (account != null && balance > 0){
            balance += balance;
            return true;
        }else {
            return false;
        }
    }
}
