package deprecation;

import java.util.Calendar;
import java.util.Date;

public class DeprecationDemo {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        int year1 = date.getYear(); // Deprecated Method
        System.out.println(year1);

        int year2 = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println(year2);
    }

}
