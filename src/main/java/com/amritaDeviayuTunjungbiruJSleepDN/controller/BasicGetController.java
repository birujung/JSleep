package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.*;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.Serializable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * An interface that provides basic RESTful APIs for getting data from a `JsonTable` object.
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @param <T> The type of the object that will be handled by the controller (e.g. Account, Room, etc.)
 */
@RestController
public interface BasicGetController <T extends Serializable> {
    /**
     * Returns the object with the specified ID.
     *
     * @param id The ID of the object to return.
     * @return The object with the specified ID, or `null` if no such object exists.
     */
    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        T object = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
        return object;
    }

    public abstract JsonTable<T> getJsonTable();

    /**
     * Returns a page of objects from the `JsonTable` object, starting from the specified page and with the specified
     * number of objects per page.
     *
     * @param page The index of the page to return.
     * @param pageSize The number of objects to return per page.
     * @return A list of objects from the `JsonTable` object.
     */
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam  int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}