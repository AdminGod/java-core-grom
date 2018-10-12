package finalProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String dateToString(Date date){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MM-YYYY");
        return formatForDateNow.format(date);
    }

    public static Date StringToDate(String s){
        Date date = null;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(s);
            return date;
        } catch (ParseException e) {
            System.out.println("Error! Can't parse string to date.Str9ing should be by next structure \"dd-MM-yyyy\"");
        }
        return null;
    }
}
