package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.Payment;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class,filepath = "/Users/tunjung/coding/Java/JSleep/src/main/java/com/amritaDeviayuTunjungbiruJSleepDN/dbjson/JsonAutowired" )
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
                    @RequestParam String from,
                    @RequestParam String to
            ) {
        return null;
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
