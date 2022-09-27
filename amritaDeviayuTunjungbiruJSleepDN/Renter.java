package amritaDeviayuTunjungbiruJSleepDN;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 * @see Serializable
 */
public class Renter extends Serializable
{
    public int phoneNumber;
    public String address;
    public String username;
    
    public Renter(int id, String username) {
        super(id);
        this.username = username;
    }
    
    public Renter(int id, String username, String address) {
        super(id);
        this.username = username;
        this.address = "";
    }
    
    public Renter(int id, String username, int phoneNumber) {
        super(id);
        this.username = username;
        this.phoneNumber = 0;
    }
    
    public Renter(int id, String username, int phoneNumber, String address) {
        super(id);
        this.username = username;
        this.phoneNumber = 0;
        this.address = "";
    }
}
