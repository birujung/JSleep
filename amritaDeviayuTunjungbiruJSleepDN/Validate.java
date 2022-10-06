package amritaDeviayuTunjungbiruJSleepDN;
import java.util.ArrayList;


/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (4-10-2022)
 */
public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less) {
        ArrayList<Double> result = new ArrayList<Double>();
        for (Price price : list) {
           if (less == true && price.price <= value) {
               if (price.price <= value) {
                   result.add(price.price);
            }
            } else if(less == false && price.price > value) {
                    result.add(price.price);
            } 
        }
        return result;
    }
}
