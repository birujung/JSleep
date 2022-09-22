package amritaDeviayuTunjungbiruJSleepDN;


/**
 * Amrita Deviayu Tunjungbiru
 * 2106636584
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
    
    public static float getDiscountedPercentage(int beforeDiscount, int afterDiscount) {
        if ( beforeDiscount <= afterDiscount ){
            return 0.0f;
        } else {
            return ((float)(beforeDiscount - afterDiscount)/ (float)beforeDiscount) * 100;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        if ( discountPercentage >= 100.0f ) {
            return 100;
        } else {
            return (int) (price * ((float)discountPercentage / 100));
        }
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        if (discountedPrice <= 0){
            return 0;
        } else {
            return (int) ((float) discountedPrice * (100.0 / (100.0 - discountPercentage)));
        }
    }
    
    public static float getAdminFeePercentage() {
        return 0.05f;
    }
    
    public static int getAdminFee(int price) {
        return (int) (price * getAdminFeePercentage());
    }
    
    public static int getTotalPrice(int price, int numberOfNight) {
        return ((price * numberOfNight) + getAdminFee(price * numberOfNight));
    } 
    
    public static void main (String[] args) {
        Room kamar = JSleep.createRoom();
        
        System.out.println(kamar.name);
        System.out.println(kamar.size);
        System.out.println(kamar.price.price);
        System.out.println(kamar.facility);
    }
    
    public static Room createRoom() {
        Price price = new Price (100000, 5);
        Room room = new Room ( "hotel", 30, price, Facility.AC );
        return room;
    }
}
