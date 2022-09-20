package amritaDeviayuTunjungbiruJSleepDN;


/**
 * Amrita Deviayu Tunjungbiru
 * 2106636584
 */
public class Price
{
    double price;
    int discount;
    double rebate;
    public Price(double price) {
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }
    
    public Price(double price, int discount) {
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    
    public Price(double price, double rebate) {
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    
    private double getDiscountedPrice() {
        if ( discount > 100.0 ){
            return 100.0;
        } else if ( discount == 100.0 ){
            return 0.0;
        } else {
            return price - (price * discount / 100);
        }
    }
    
    private double getRebatedPrice() {
        if ( rebate > price ){
            return price;
        } else {
            return price - rebate;
        }
    }
}
