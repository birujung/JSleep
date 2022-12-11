package com.amritaDeviayuTunjungbiruJSleepDN;

import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.Serializable;

/**
 * The `Voucher` class represents a voucher that can be applied to reduce the price of a room.
 *
 * @author  Amrita Deviayu Tunjungbiru
 * @version 1.0
 * @since 11 December 2022
 * @see Serializable
 */
public class Voucher extends Serializable
{
    /**
     * The type of voucher (rebate or discount).
     */
    public Type type;

    /**
     * The amount of the voucher.
     */
    public double cut;

    /**
     * The name of the voucher.
     */
    public String name;

    /**
     * The unique code of the voucher.
     */
    public int code;

    /**
     * The minimum price required for the voucher to be applied.
     */
    public double minimum;

    /**
     * A boolean value indicating whether the voucher has been used.
     */
    private boolean used;

    /**
     * Constructs a new `Voucher` instance with the specified name, code, type, minimum price, and amount.
     *
     * @param name  The name of the voucher.
     * @param code  The unique code of the voucher.
     * @param type  The type of voucher (rebate or discount).
     * @param used  A boolean value indicating whether the voucher has been used.
     * @param minimum  The minimum price required for the voucher to be applied.
     * @param cut  The amount of the voucher.
     */
    public Voucher(String name, int code, Type type, boolean used, double minimum, double cut) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = false;
        this.minimum = minimum;
        this.cut = cut;
    }

    /**
     * Checks if the voucher can be applied to the specified price.
     *
     * @param price  The price to check against the voucher's minimum price and usage status.
     * @return `true` if the voucher can be applied, `false` otherwise.
     */
    public boolean canApply(Price price) {
        if (price.price > this.minimum && this.used == false) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Applies the voucher to the specified price.
     *
     * @param price  The price to apply the voucher to.
     * @return  The reduced price after the voucher has been applied.
     */
    public double apply(Price price) {
        if (this.used == true) {
            if (this.type == Type.DISCOUNT) {
                if (this.cut > 100) {
                    this.cut = 100.0;
                    return 0;
                } else {
                    return (double) price.price * (100 - this.cut) / 100;
                }
            } else if (this.type == Type.REBATE) {
               if (this.cut > price.price) {
                   this.cut = price.price;
               } else {
                   return (double) price.price - this.cut;
               }
            }
        } 
        return 0;
    }

    /**
     * Checks if the voucher has been used.
     *
     * @return `true` if the voucher has been used, `false` otherwise.
     */
    public boolean isUsed() {
        return used = true;
    }
}
