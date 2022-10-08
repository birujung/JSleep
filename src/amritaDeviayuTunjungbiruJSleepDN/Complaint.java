package amritaDeviayuTunjungbiruJSleepDN;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (29-09-2022)
 */
public class Complaint extends Serializable
{
    public String date;
    public String desc;
    
    public Complaint(int id, String date, String desc) {
        super(id);
        this.date = date;
        this.desc = desc;
    }
    
    public String toString() {
            return "\nDate: " + date + "\nDescription: " + desc;
        }
}
