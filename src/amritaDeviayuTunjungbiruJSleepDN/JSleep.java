package amritaDeviayuTunjungbiruJSleepDN;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class JSleep {
    public static void main(String[] args) {
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        try {
            String filepath = "/Users/tunjung/coding/Java/JSleep/src/json/randomRoomList.json";

            JsonTable<Room> tableRoom =  new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static <Room> List<Room> filterByCity(List<Room> list, String search, int page, int pageSize) {
       // return Algorithm.<Room>paginate(list, page, pageSize, i -> i.city.toString().toLowerCase().contains(search.toLowerCase()));
        return list;
    }

    public static <Room> List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice) {
        /*List<Room> filteredList = new ArrayList<Room>();

        for(Room check : list) {
            if (check.min == minPrice) {
                filteredList.add(check);
            }
        }
        return Algorithm.paginate(filteredList, minPrice, maxPrice,pred -> true);*/
        return list;
    }

    public static <Room> List<Room> filterByAccoundId(List<Room> list, int accountId, int page, int pageSize) {
        /*List<Room> filteredList = new ArrayList<Room>();

        for(Room check : list) {
            if (check.accountId == accountId) {
                filteredList.add(check);
            }
        }
        return Algorithm.paginate(filteredList, page, pageSize,pred -> true);*/
        return list;
    }
}
    /*class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    // sesuaikan dengan lokasi di sistem kepada city.json
        String filepath = "/Users/tunjung/coding/Java/JSleep/src/city.json";
        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("populatioon: " + input.population);
            System.out.println("states :");
            input.listOfStates.forEach (state -> System.out.println(state));
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
        /*System.out.print("Hello from Intellij!");
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-18");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-15");
        Date end2 = Date.valueOf("2022-8-18");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-15");
        Date end3 = Date.valueOf("2022-8-18");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));
        
        System.out.println("Membuat booking dari tanggal 20 hingga 15");
        start = Date.valueOf("2022-8-20");
        end = Date.valueOf("2022-8-15");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        /*Payment testPayment = new Payment(2, 2, 2,2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        for (int i=0;i < unfilteredArray.length;i++) {
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }
        System.out.println("Price List");
        for (int i=0;i < unfilteredArray.length;i++) {
            System.out.println(unfilteredArray[i].price);
        }
        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000,true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000,false));
        Room kamar = JSleep.createRoom();
        
        System.out.println(kamar.name);
        System.out.println(kamar.size);
        System.out.println(kamar.price.price);
        System.out.println(kamar.facility);
        
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2, 2, 2, "");
        
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print());
        
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
        System.out.println(testRating.toString()); */

    /*
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
    }*/
    
    /*public static Room createRoom() {
        Price price = new Price (100000, 0.5);
        Room room = new Room ("Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Bareng Sama Ayang");
        return room;
    }
}*/
