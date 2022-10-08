package amritaDeviayuTunjungbiruJSleepDN;


/**
 * Amrita Deviayu Tunjungbiru
 * 2106636584
 */
public class Rating
{
    private long total;
    private long count;
    
    public Rating() {
        this.total = 0;
        this.count = 0;
    }
    
    public void insert(int rating) {
        this.total += rating;
        count++;
    }
    
    public double getAverage() {
        if ( this.count == 0 ){
            return 0;
        } else {
        return total / count;
        }
    }
    
    public long getCount() {
        return count;
    }
    
    public long getTotal() {
        return total;
    }
    
    public String toString() {
        return "\nTotal: " + total + "\nCount: " + count;
    }
}
