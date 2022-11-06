package com.amritaDeviayuTunjungbiruJSleepDN;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Voucher extends Serializable
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;
    
    public Voucher(String name, int code, Type type, boolean used, double minimum, double cut) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = false;
        this.minimum = minimum;
        this.cut = cut;
    }
    
    public boolean canApply(Price price) {
        if (price.price > this.minimum && this.used == false) {
            return true;
        } else {
            return false;
        }
    }
    
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
    
    public boolean isUsed() {
        return used = true;
    }

    public Object write() {
        return null;
    }
    
    public boolean read(String content) {
        return false;
    }
}
