package amritaDeviayuTunjungbiruJSleepDN;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Account extends Serializable implements FileParser
{
    public String name;
    public String email;
    public String password;
    
    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString() {
        return "\nName: " + name +
                "\nEmail: " + email +
                "\nPassword: " + password;
    }
    
    @Override
    public Object write() {
        return null;
    }
    
    public boolean read(String content) {
        return false;
    }
}
