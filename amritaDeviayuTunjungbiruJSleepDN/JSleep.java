package amritaDeviayuTunjungbiruJSleepDN;


/**
 * Write a description of class JSleep here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JSleep
{
    
    getHotelId();
    getHotelName();
    System.out.println(getHotelName());
    
    isDiscount();
    getDiscountPercentage(int beforeDiscount, float afterDsicount);
    
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
        String
        discountedPrice = discountedPrice * discountPercentage;
    }
    
    public static float getAdminFeePercentage() {
        
    }
    
    public static int getAdminFee(int ) {
        
    }
    
    public static int getTotalPrice(int , int ) {
        
    }
}
