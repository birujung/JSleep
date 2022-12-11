package com.amritaDeviayuTunjungbiruJSleepDN;

import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.Serializable;

/**
 * A class that represents an invoice for a rental transaction.
 *
 * <p>This class extends the `Serializable` class and adds fields for the IDs of the buyer and renter, the payment status, and the rating of the rental. It also provides a `print()` method that returns a string representation of the invoice.</p>
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 * @see Serializable
 */
public class Invoice extends Serializable {
    /**
     * This enum represents the different types of rating the room can have.
     */
    public enum RoomRating {
        NONE, BAD, NEUTRAL, GOOD
    }

    /**
     * This enum represents the different types of payment status the room can have.
     */
    public enum PaymentStatus {
        FAILED, WAITING, SUCCESS
    }

    /**
     *  The ID of a Buyer
     */
    public int buyerId;

    /**
     *  The ID of a Renter
     */
    public int renterId;

    /**
     *  The rating the room can have
     */
    public RoomRating rating;

    /**
     *  The status of payment
     */
    public PaymentStatus status;

    /**
     * Constructs a new Invoice.
     *
     * @param buyerId The account that makes a booking
     * @param renterId The renter that provides the room
     */
    protected Invoice(int buyerId, int renterId) {
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * Constructs a new Invoice.
     *
     * @param buyer The account that makes a booking
     * @param renter The renter that provides the room
     */
    public Invoice(Account buyer, Renter renter) {
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * This method is used to show the date and description of a complaint.
     *
     * @return String of Invoice ID, Buyer ID, Renter ID, Payment Status, and Rating
     */
    public String print() {
        return "Invoice ID: " + id +
                "\nBuyer ID: " + buyerId +
                "\nRenter ID: " + renterId +
                "\nPayment Status: " + status +
                "\nRating: " + rating;
    }
}
