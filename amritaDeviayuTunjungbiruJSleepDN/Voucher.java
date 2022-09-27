package amritaDeviayuTunjungbiruJSleepDN;


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
    
    public Voucher(int id, String name, int code, Type type, double minimum, double cut) {
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
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
                    return price.price * (100 - this.cut) / 100;
                }
            } else if (this.type == Type.REBATE) {
               if (this.cut > price.price) {
                   this.cut = price.price;
               } else {
                   return price.price - this.cut;
               }
            }
        } 
        return 0;
    }
    
    public boolean isUsed() {
        return used;
    }
}
