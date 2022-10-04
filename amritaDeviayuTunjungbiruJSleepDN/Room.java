package amritaDeviayuTunjungbiruJSleepDN;


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
    public BedType bedtype;
    public City city;
    
    public Room(int id, String name, int size, Price price, Facility facility, City city, String address) {
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.address = address;
        this.bedtype = BedType.SINGLE;
        this.city = city;
        this.address = address;
    }
    
    public String toString() {
        return "\nID: " + id + "\nName: " + name + "\nAddress: " + address + "\nCity: " + city + "\nFacility: " + facility + "\nSize: " + size;
    }
    
    public Object write() {
        return null;
    }
    
    public boolean read(String content) {
        return false;
    }
}
