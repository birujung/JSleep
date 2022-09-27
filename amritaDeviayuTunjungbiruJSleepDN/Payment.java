package amritaDeviayuTunjungbiruJSleepDN;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Payment extends Invoice
{
    public String to;
    public String from;
    private int roomId;
    
    public Payment(int id, int buyerId, int renterId, String time, int roomId, String from, String to) {
        super(id, buyerId, renterId, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to) {
        super(id, buyer, renter, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public String print() {
        return "\n" + "Buyer ID: " + buyerId + "\nRenter ID: " + renterId + "\nTime: " + time + "\nRoom ID: " 
        + roomId + "\nFrom: " + from + "\nTo: " + to + "\n";
    }
    
    public int getRoomId(int roomId) {
        return roomId;
    }
}
