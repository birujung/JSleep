package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.Algorithm;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.Serializable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable> {
    @GetMapping ("/{id}")
    public default T getById(@PathVariable int id) {
        T objek = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
        return objek;
    }

    public JsonTable<T> getJsonTable();
    @GetMapping ("/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}
