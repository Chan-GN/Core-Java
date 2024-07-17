package collections;

import java.util.Date;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class MapDemo {

    public static void main(String[] args) {
        Date date = new Date();
        String dateString = date.toString();

        /* String Parsing
         * 1. split()
         * 2. Scanner Class's useDelimiter()
         * 3. StringTokenizer
         */

        StringTokenizer st = new StringTokenizer(dateString);
        String[] strings = new String[st.countTokens()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = st.nextToken();
        }

        System.out.println(strings[5] + "년 " +
                getMonthByName(strings[1]) + "월 " +
                strings[2] + "입니다.");

    }

    private static int getMonthByName(String month) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("Jan", 1);
        ht.put("Feb", 2);
        ht.put("Mar", 3);
        ht.put("Apr", 4);
        ht.put("May", 5);
        ht.put("Jun", 6);
        ht.put("Jul", 7);
        ht.put("Aug", 8);
        ht.put("Sep", 9);
        ht.put("Oct", 10);
        ht.put("Nov", 11);
        ht.put("Dec", 12);

        return ht.get(month);
    }

}
