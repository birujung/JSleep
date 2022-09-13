package amritaDeviayuTunjungbiruJSleepDN;


/**
 * Write a description of class JSleep here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JSleep
{
    
    public static int getHotelId() {
        return 0;
    }
    
    public static String getHotelName() {
        return "Hotel";
    }
    
    public static boolean isDiscount() {
        return true;
    }
    
    public static float getDiscountedPercentage(int beforeDiscount, float afterDiscount) {
        if ( beforeDiscount < afterDiscount ){
            return 0.0f;
        } else {
            return beforeDiscount / 100f;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        if ( discountPercentage > 100.0f ) {
            return 100;
        } else {
            return 0;
        }
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        int originalPrice = discountedPrice * getDiscountedPrice();
        return originalPrice;
    }
    
    public static float getAdminFeePercentage() {
        return 0.05f;
    }
    
    public static int getAdminFee(int price) {
        int adminFee = getAdminFeePercentage * price;
        
        return adminFee;
    }
    
    public static int getTotalPrice(int price, int numberOfNight) {
        int totalPrice = price * numberOfNight + adminFee;
        return totalPrice;
    } 
}
