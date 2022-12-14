package com.amritaDeviayuTunjungbiruJSleepDN;

import java.util.Calendar;
import java.util.Date;

/**
 * A class representing a payment for booking a room.
 *
 * <p>This class extends the `Invoice` class and adds additional attributes and methods related to the payment,
 * such as the dates of the booking, the room ID, and methods for checking the availability of a room and making a booking.</p>
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @since 27 September 2022
 * @version 1.0
 * @see Invoice
 */
public class Payment extends Invoice {
    /**
     *  The start date of the booking
     */
    public Date to;

    /**
     *  The end date of a booking
     */
    public Date from;

    /**
     *  The ID of a Room
     */
    private final int roomId;

    /**
     * Constructs a new Payment.
     *
     * @param buyerId The account that makes a booking
     * @param renterId The renter that provides the room
     * @param from The start date of a booking
     * @param to The end date of a booking
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs a new Payment.
     *
     * @param buyer The account that makes a booking
     * @param renter The renter that provides the room
     * @param from The start date of a booking
     * @param to The end date of a booking
     */
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * A method to get room ID for payment
     *
     * @return room ID
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Checks whether a room is available to be booked within the given date range.
     *
     * @param from The start date of the booking
     * @param to The end date of the booking
     * @param room The Room to check availability for
     * @return true if the Room is available within the given date range, false otherwise
     */
    public static boolean availability(Date from, Date to, Room room) {
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }

    /**
     * This method checks the availability of a room for a given time period.
     *
     * @param from The start date of the booking period
     * @param to The end date of the booking period
     * @param room The room to be booked
     * @return true if the room is available for the given time period, false otherwise
     */
    public static boolean makeBooking(Date from, Date to, Room room) {
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }

    /**
     * This method is used to show the date and description of a complaint.
     *
     * @return String of Buyer ID, Renter ID, Room ID, start and end date of booking
     */
    public String print() {
        return "\nBuyer ID: " + buyerId +
                "\nRenter ID: " + renterId +
                "\nRoom ID: " + roomId +
                "\nFrom: " + from +
                "\nTo: " + to;
    }
}
