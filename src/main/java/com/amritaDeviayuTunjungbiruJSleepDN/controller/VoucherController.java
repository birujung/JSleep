package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.*;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * A REST controller that provides methods to provide available voucher, apply voucher, and used voucher.
 *
 * It implements the {@link BasicGetController} interface and uses a JsonTable of Voucher objects to store
 * voucher information.
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @see Voucher
 */
@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {
    /**
     * A `JsonTable` that stores voucher data.
     *
     * @JsonAutowired indicates that this field should be initialized with data from the specified file.
     */
    @JsonAutowired(value = Voucher.class,filepath = "/Users/tunjung/coding/Java/JSleep/src/json/voucher.json" )
    public static JsonTable<Voucher> voucherTable;

    /**
     * Returns the `JsonTable` object that stores the voucher.
     *
     * @return The `JsonTable` object that stores the voucher.
     */
    @Override
    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    /**
     * Check if a voucher with the given ID can be applied to a given price.
     *
     * @param id The ID of the voucher to check.
     * @param price The price to check against.
     * @return `true` if the voucher can be applied to the given price, `false` otherwise.
     */
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

    /**
     * Check if a voucher with the given ID has been used.
     *
     * @param id The ID of the voucher to check.
     * @return `true` if the voucher has been used, `false` otherwise.
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed (
            @PathVariable int id
            ) {
        Voucher check = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return check.isUsed();
    }

    /**
     * Retrieve a paginated list of available vouchers.
     *
     * @param page The page number to retrieve.
     * @param pageSize The number of vouchers per page.
     * @return A paginated list of available vouchers.
     */
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
