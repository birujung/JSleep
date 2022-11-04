package amritaDeviayuTunjungbiruJSleepDN;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (27-09-2022)
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    public static final String REGEX_EMAIL = "^(?=.*{1,}@)[A-Za-z0-9]+@[^-][A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}$";


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

    public boolean validate() {
        //untuk email
        Pattern patternEm = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEm = patternEm.matcher(email);
        boolean matchFoundEm = matcherEm.find();

        //untuk password
        Pattern patternPass = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPass = patternPass.matcher(password);
        boolean matchFoundPass = matcherPass.find();

        return matchFoundEm && matchFoundPass;
    }
    
    /*public boolean read(String content) {
        return false;
    }*/
}
