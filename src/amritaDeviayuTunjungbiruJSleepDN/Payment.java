package amritaDeviayuTunjungbiruJSleepDN;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private final int roomId;

    public Payment(int buyerId, int renterId, int roomId, Date from, Date to) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public static boolean availability(Date from, Date to, Room room) {
        if(from.equals(to)){
            return false;
        }
        
        for(Date date : room.booked){
            if(from.equals(date)){
                return false;
            } else if (from.before(date) && to.after(date)) {
                return false;
            }
        }
        return true;
    }
    
    public String getTime() {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
    
        return "Formatted Date: " + SDFormat.format(this.from.getTime());
    }
    
    public static boolean makeBooking(Date from, Date to, Room room) {
        if(to.before(from)) {
            return false;
        }

        if(availability(from, to, room)) {
            while (from.before(to)){
                room.booked.add(from);
                Calendar c = Calendar.getInstance();
                c.setTime(from);
                c.add(Calendar.DATE, 1);
                from = c.getTime();
            }
            return true;
        }return false;
    }
    
    public String print() {
        return "\nBuyer ID: " + buyerId +
                "\nRenter ID: " + renterId +
                "\nTime: " + time +
                "\nRoom ID: " + roomId +
                "\nFrom: " + from +
                "\nTo: " + to;
    }
    
    public int getRoomId(int roomId) {
        return this.roomId;
    }
}
