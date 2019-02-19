package by.it.titkovskaya.jd03_02.helpFiles;

import com.sun.jmx.snmp.Timestamp;
import java.util.Date;

public class ShowTimestamp {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp();

        long dateTime = timestamp.getDateTime();
        System.out.println("\nCurrent time LONG (nanoseconds):\n" + dateTime);

        Date standardDate = new Date(dateTime);
        System.out.println("\nTimestamp in standard format:\n" + timestamp.getDate() +"\n" + standardDate);

        Date dateFromLong = new Date(1550564702447L);
        System.out.println("\nConversion from LONG:\n" + dateFromLong);

    }
}

