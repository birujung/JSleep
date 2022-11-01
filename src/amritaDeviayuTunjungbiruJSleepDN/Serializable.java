package amritaDeviayuTunjungbiruJSleepDN;
import java.util.HashMap;

/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (11-10-2022)
 */
public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if(counter == null) {
            counter = 0;
        } else {
            counter += 1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public boolean equals(Object lain) {
        return lain instanceof Serializable && ((Serializable)lain).id == this.id;
    }

    protected boolean equals(Serializable lain) {
        return lain.id == this.id;
    }

    public static <T extends Serializable> Integer getClosingId(Class<T> kelas) {
        return mapCounter.get(kelas);
    }

    public static <T> Integer setClosingId(Class<T> kelas, int id) {
        return mapCounter.put(kelas, id);
    }

    public int compareTo(Serializable lain) {
        return Integer.compare(this.id, lain.id);
    }
}
