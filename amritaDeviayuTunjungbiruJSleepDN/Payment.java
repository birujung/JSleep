package amritaDeviayuTunjungbiruJSleepDN;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Payment extends Invoice
{
    public Calendar to;
    public Calendar from;
    private int roomId;
    
    public Payment(int id, int buyerId, int renterId, int roomId) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
    public String getTime() {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
    
        return "Formatted Date: " + SDFormat.format(this.from.getTime());
    }
    
    public String getDuration() {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        
        return SDFormat.format(this.from.getTime()) + " " + "-" + " " + SDFormat.format(this.to.getTime());
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
        return roomId;
    }
}
