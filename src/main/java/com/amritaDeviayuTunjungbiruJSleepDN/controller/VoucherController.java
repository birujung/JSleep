package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.*;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    @JsonAutowired(value = Voucher.class,filepath = "/Users/tunjung/coding/Java/JSleep/src/json/voucher.json" )
    public static JsonTable<Voucher> voucherTable;

    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    @GetMapping("/{id}canApply")
    boolean canApply
            (
                    @PathVariable int id,
                    @RequestParam double price
            ) {
        return false;
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        return Algorithm.<Voucher>paginate(getJsonTable(), page, pageSize, pred -> false);
    }
}
