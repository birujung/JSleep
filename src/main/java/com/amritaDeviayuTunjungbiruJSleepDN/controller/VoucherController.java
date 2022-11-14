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

    @Override
    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    @GetMapping("/{id}/canApply")
    boolean canApply
            (
                    @PathVariable int id,
                    @RequestParam double price
            ) {
        Voucher check = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        if(check == null){
            return false;
        }
        return check.canApply(new Price(price));
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed (
            @PathVariable int id
            ) {
        Voucher check = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return check.isUsed();
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        List<Voucher> collectVoucher = Algorithm.<Voucher>collect(getJsonTable(), pred -> true);
        List<Voucher> availableVoucher = new ArrayList<>();
        for(Voucher voucher : collectVoucher){
            if(!voucher.isUsed()){
                availableVoucher.add(voucher);
            }
        }
        return Algorithm.<Voucher>paginate(availableVoucher, page, pageSize, pred -> true);
    }
}
