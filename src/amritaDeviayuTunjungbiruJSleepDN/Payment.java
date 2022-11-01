package amritaDeviayuTunjungbiruJSleepDN;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    public int getRoomId(int roomId) {
        return this.roomId;
    }

    public static boolean availability(Date from, Date to, Room room) {
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }
    
    public String getTime() {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
    
        return "Formatted Date: " + SDFormat.format(time.getTime());
    }
    
    public static boolean makeBooking(Date from, Date to, Room room) {
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }
    
    public String print() {
        return "\nBuyer ID: " + buyerId +
                "\nRenter ID: " + renterId +
                "\nTime: " + time +
                "\nRoom ID: " + roomId +
                "\nFrom: " + from +
                "\nTo: " + to;
    }
}
