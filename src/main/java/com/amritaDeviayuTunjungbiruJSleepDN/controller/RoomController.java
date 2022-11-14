package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.*;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {
    @JsonAutowired(value = Room.class,filepath = "/Users/tunjung/coding/Java/JSleep/src/json/room.json" )
    public static JsonTable<Room> roomTable;

    @Override
    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }

    @GetMapping("/{id}renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    @PostMapping("/create")
    public Room create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int size,
                    @RequestParam int price,
                    @RequestParam Facility facility,
                    @RequestParam City city,
                    @RequestParam String address
            ) {
        Account check = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if (check != null) {
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address);
            roomTable.add(room);
            return room;
        } else {
            return null;
        }

    }
}
