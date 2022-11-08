package com.amritaDeviayuTunjungbiruJSleepDN;
import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.Serializable;

/**
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @version (29-09-2022)
 */
public class Complaint extends Serializable
{
    public String date;
    public String desc;
    
    public Complaint(String date, String desc) {
        this.date = date;
        this.desc = desc;
    }
    
    public String toString() {
            return "\nDate: " + date + "\nDescription: " + desc;
        }
}
