import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeDemo {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        System.out.printf("%d년 %d월 %d일, %d시 %d분 %d초\n",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.printf("%d년 %d월 %d일, %d시 %d분 %d초\n",
                gregorianCalendar.get(Calendar.YEAR), gregorianCalendar.get(Calendar.MONTH) + 1,
                gregorianCalendar.get(Calendar.DATE), gregorianCalendar.get(Calendar.HOUR_OF_DAY),
                gregorianCalendar.get(Calendar.MINUTE), gregorianCalendar.get(Calendar.SECOND));

        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, Locale.KOREA);
        System.out.println(df.format(new Date()));

        DateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));

        String pattern = String.format("%1$tY년 %1$tm월 %1$td일\n", new Date());
        System.out.println(pattern);
    }

}
