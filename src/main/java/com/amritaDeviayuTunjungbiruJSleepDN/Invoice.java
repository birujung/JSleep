package com.amritaDeviayuTunjungbiruJSleepDN;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.Serializable;
import java.util.Calendar;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Invoice extends Serializable
{
    public enum RoomRating {
        NONE, BAD, NEUTRAL, GOOD
    }

    public enum PaymentStatus {
        FAILED, WAITING, SUCCESS
    }

    public int buyerId;
    public int renterId;
    public RoomRating rating;
    public PaymentStatus status;

    protected Invoice(int buyerId, int renterId) {
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public Invoice(Account buyer, Renter renter) {
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public String print() {
        return "Invoice ID: " + id +
                "\nBuyer ID: " + buyerId +
                "\nRenter ID: " + renterId +
                "\nPayment Status: " + status +
                "\nRating: " + rating;
    }
}