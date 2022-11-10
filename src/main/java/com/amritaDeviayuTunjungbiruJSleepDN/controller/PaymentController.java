package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.Account;
import com.amritaDeviayuTunjungbiruJSleepDN.Payment;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Account.class,filepath = "/Users/tunjung/coding/Java/JSleep/src/json/payment.json" )
    public static JsonTable<Payment> paymentTable;

    @GetMapping
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/create")
    public Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int renterId,
                    @RequestParam int roomId,
                    @RequestParam Date from,
                    @RequestParam Date to
            ) {
        paymentTable.add(new Payment(buyerId,renterId,roomId,from,to));
        return new Payment(buyerId,renterId,roomId,from,to);
    };

    @PostMapping("/{id}accept")
    boolean accept(@PathVariable int id) {
        return false;
    }

    @PostMapping("/{id}cancel")
    boolean cancel(@PathVariable int id) {
        return false;
    }

    @PostMapping("/{id}submit")
    boolean submit(@PathVariable int id) {
        return false;
    }
}