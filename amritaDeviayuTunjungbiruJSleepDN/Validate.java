package amritaDeviayuTunjungbiruJSleepDN;
import java.util.ArrayList;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (4-10-2022)
 */
public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less) {
        ArrayList<Price> result = new ArrayList<Price>();
        for (Price price : list) {
           if (less == true) {
               if (price.price <= value) {
                   result.add(price);
            }
            } else {
                if (price.price > value) {
                    result.add(price);
                }
            } 
        }
        return result;
    }
}
