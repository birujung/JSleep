package com.amritaDeviayuTunjungbiruJSleepDN;


/**
 * This class represents a price for a product or service.
 *
 * <p>The price can have a discount applied to it, and a rebate can be provided as well.</p>
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (11-10-2022)
 */
public class Price {
    /**
     *  The base price of the room.
     */
    public double price;

    /**
     * The discount applied to the price as a percentage (e.g. 20 for 20%).
     */
    public double discount;

    /**
     * Constructs a new Price instance with the given base price and no discount.
     *
     * @param price The base price of the room
     */
    public Price(double price) {
        this.price = price;
        this.discount = 0;
    }

    /**
     * Constructs a new Price instance with the given base price and discount.
     *
     * @param price The base price of the room
     * @param discount The discount that will be applied to the original price
     */
    public Price(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }

    /**
     * This method is used to show the price and discount of a room.
     *
     * @return String of price and discount
     */
    public String toString() {
        return "\nPrice: " + price + "\nDiscount: " + discount;
    }
}