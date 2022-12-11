package com.amritaDeviayuTunjungbiruJSleepDN.controller;

import com.amritaDeviayuTunjungbiruJSleepDN.*;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonTable;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;
import java.text.*;
import java.util.*;

/**
 * A REST controller that provides methods to create, accept, cancel, and submit payments.
 *
 * This class implements the {@link BasicGetController} interface, which provides methods to
 * get a single object by ID and to get a page of objects from the `JsonTable Payment` that stores the data.
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @see Payment
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    /**
     * A `JsonTable` that stores payment data.
     *
     * @JsonAutowired indicates that this field should be initialized with data from the specified file.
     */
    @JsonAutowired(value = Account.class,filepath = "/Users/tunjung/coding/Java/JSleep/src/json/payment.json" )
    public static JsonTable<Payment> paymentTable;

    /**
     * Returns the `JsonTable` object that stores the payment data.
     *
     * @return The `JsonTable` object that stores the payment data.
     */
    @GetMapping
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    /**
     * This method creates a new payment for a room booking.
     * The payment is created by providing the buyer's id, the renter's id, the room's id, and the dates of the booking.
     *
     * @param buyerId The id of the buyer making the payment
     * @param renterId The id of the renter who owns the room being booked
     * @param roomId The id of the room being booked
     * @param from The start date of the booking
     * @param to The end date of the booking
     * @return A Payment object representing the newly created payment, or null if the payment could not be created
     * @throws ParseException if the date strings provided could not be parsed into Date objects
     */
    @PostMapping("/create")
    public Payment create
            (
                    @RequestParam int buyerId,
                    @RequestParam int renterId,
                    @RequestParam int roomId,
                    @RequestParam String from,
                    @RequestParam String to
            ) throws ParseException {
        Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId);

        double price = room.price.price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        if (acc == null || room == null || acc.balance <= room.price.price || !Payment.availability(fromDate, toDate, room)) {
            return null;
        }
        else{
            Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
            acc.balance -= price;
            payment.status = Invoice.PaymentStatus.WAITING;
            if(Payment.makeBooking(fromDate, toDate, room)){
                paymentTable.add(payment);
                return payment;
            }
            else{
                return null;
            }
        }
    }

    /**
     * This method is used to accept a payment with a given ID.
     *
     * @param id The ID of the payment to be accepted.
     * @return true if the payment was successfully accepted, false otherwise.
     */
    @PostMapping("/{id}/accept")
    boolean accept(@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    /**
     * This method is used to cancel a payment with a given ID.
     *
     * @param id The ID of the payment to be canceled.
     * @return true if the payment was successfully canceled, false otherwise.
     */
    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.FAILED;
            Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.renterId);
            acc.balance += room.price.price;
            return true;
        }
        return false;
    }

    /**
     * This method is used to submit a payment with a given ID.
     *
     * @param id The ID of the payment to be submitted.
     * @return false if the payment was successfully submitted.
     */
    @PostMapping("/{id}/submit")
    boolean submit(@PathVariable int id) {
        return false;
    }

    /**
     * This method is used to get all the order for renter.
     * This method uses the paginate method from the Algorithm class to paginate the results.
     *
     * @param renterId The ID of the Renter.
     * @param page The page number to be return.
     * @param pageSize The number of payment objects to return on each page.
     * @return The payments for the specified renter ID.
     */
    @GetMapping("/getOrderForRenter")
    public List<Payment> getOrderForRenter(
            @RequestParam int renterId,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Payment>paginate(getJsonTable(),page,pageSize,pred -> pred.renterId == renterId);
    }

    /**
     * This method is used to get all the order for buyer.
     * This method uses the collect method from the Algorithm class to collect the results.
     *
     * @param buyerId The ID of the Buyer.
     * @return A list of 'Payment' objects that are associated with the specified buyer ID.
     */
    @GetMapping("/getOrderForBuyer")
    public List<Payment> getOrderForBuyer(
            @RequestParam int buyerId
    ){
        return Algorithm.<Payment>collect(getJsonTable(),pred -> pred.buyerId == buyerId);
    }
}