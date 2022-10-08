package amritaDeviayuTunjungbiruJSleepDN;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Room extends Serializable implements FileParser
{
    public String name;
    public int size;
    public Price price;
    public Facility facility;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;
    
    public Room(int id, String name, int size, Price price, Facility facility, City city, String address) {
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.address = address;
        this.bedType = BedType.SINGLE;
        this.city = city;
        this.address = address;
        this.booked = new ArrayList<Date>();
    }
    
    public String toString() {
        return "\nID: " + id + 
                "\nName: " + name +
                "\nAddress: " + address +
                "\nCity: " + city +
                "\nFacility: " + facility +
                "\nSize: " + size +
                "\n(" + price + ")" +
                "\nBed Type: " + bedType;
    }
    
    @Override
    public Object write() {
        return null;
    }

    public boolean read(String content) {
        return false;
    }
}
