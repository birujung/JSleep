package amritaDeviayuTunjungbiruJSleepDN;
import java.util.Calendar;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Invoice extends Serializable
{
    public enum RoomRating {
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public enum PaymentStatus {
        FAILED, WAITING, SUCCESS
    }
    
    public int buyerId;
    public int renterId;
    public Calendar time;
    public RoomRating rating;
    public PaymentStatus status;
    
    protected Invoice(int id, int buyerId, int renterId) {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(int id, Account buyer, Renter renter) {
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = Calendar.getInstance();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print() {
        return "Invoice ID: " + id + "\nBuyer ID: " + buyerId + "\nRenter ID: " + renterId + "\nTime: " + time + "\nPayment Status: " + status + "\nRating: " + rating;
    }
}