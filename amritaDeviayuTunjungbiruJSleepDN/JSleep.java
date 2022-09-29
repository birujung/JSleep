package amritaDeviayuTunjungbiruJSleepDN;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
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
        /*Room kamar = JSleep.createRoom();
        
        System.out.println(kamar.name);
        System.out.println(kamar.size);
        System.out.println(kamar.price.price);
        System.out.println(kamar.facility);
        
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2, 2, 2, "");
        
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print());*/
        
        Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice,
        Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());
    }
    /*
    public static Room createRoom() {
        Price price = new Price (100000, 5);
        Room room = new Room (1, "hotel", 30, price, Facility.AC );
        return room;
    }*/
}
