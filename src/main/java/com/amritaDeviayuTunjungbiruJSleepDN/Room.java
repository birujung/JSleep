package com.amritaDeviayuTunjungbiruJSleepDN;

import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents a room in a hotel.
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @since 27 September 2022
 * @version 1.0
 */
public class Room extends Serializable
{
    /** The name of the room. */
    public String name;

    /** The size of the room in square meters. */
    public int size;

    /** The price of the room. */
    public Price price;

    /** The facilities available with the room. */
    public ArrayList<Facility> facility= new ArrayList<>();

    /** The address of the room. */
    public String address;

    /** The type of bed in the room. */
    public BedType bedType;

    /** The city where the room is located. */
    public City city;

    /** The ID of the account that owns the room. */
    public int accountId;

    /** The dates on which the room is booked. */
    public ArrayList<Date> booked;

    /**
     * Constructs a new `Room` object with the given parameters.
     *
     * @param accountId  The ID of the account that owns the room.
     * @param name       The name of the room.
     * @param size       The size of the room in square meters.
     * @param price      The price of the room.
     * @param facility   The facilities available in the room.
     * @param city       The city where the room is located.
     * @param address    The address of the room.
     * @param bedType    The type of bed in the room.
     */
    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address, BedType bedType) {
        super();
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility.addAll(facility);
        this.bedType = bedType;
        this.city = city;
        this.address = address;
        this.booked = new ArrayList<Date>();
    }

    /**
     * Returns a string representation of the `Room` object.
     *
     * @return a string representation of the `Room` object.
     */
    public String toString() {
        return "\nID: " + id +
                "\nName: " + name +
                "\nAddress: " + address +
                "\nCity: " + city +
                "\nFacility: " + facility +
                "\nSize: " + size +
                "\n(" + price + ")" +
                "\nBed Type: " + bedType;
    }
}