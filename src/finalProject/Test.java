package finalProject;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) throws ParseException {
        /**
        //System.out.println((new SimpleDateFormat("dd-MM-yyyy")).parse("20/11/18"));
        RoomDao roomDao = new RoomDao() ;
        HotelDao hotelDao  = new HotelDao() ;
        System.out.println(hotelDao.findHotelById(1111L).toString());
        //System.out.println(Period.between(new Date(), new Date()).getDays());
        System.out.println(TimeUnit.DAYS.convert((new Date().getTime() - new Date().getTime()), TimeUnit.MILLISECONDS));
        System.out.println(new Date().equals(new SimpleDateFormat("dd-MM-yyyy").parse("07-10-2018")));
        System.out.println(new Date().equals(new Date()));
         */
        //System.out.println((new String[]{"sdh", "sdh"}).toString());
        Date date1 = new Date();
        long date2 = 3*1000*60*24;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date1);
        cal.add(Calendar.DATE, 3);
        Date bookingDateTo = cal.getTime();
        System.out.println(bookingDateTo);
        System.out.println(date1);
        System.out.println(date2);
    }

    static class T{};

    static class T1 extends T{
        String param1;
        String param2;

        public T1(String param1, String param2) {
            this.param1 = param1;
            this.param2 = param2;
        }

        @Override
        public String toString() {
            return "T1{" +
                    "param1='" + param1 + '\'' +
                    ", param2='" + param2 + '\'' +
                    '}';
        }
    }

    static class T2 extends T{
        String param1;
        String param2;
        String param3;


        public T2(String param1, String param2, String param3) {
            this.param1 = param1;
            this.param2 = param2;
            this.param3 = param3;
        }

        @Override
        public String toString() {
            return "T2{" +
                    "param1='" + param1 + '\'' +
                    ", param2='" + param2 + '\'' +
                    ", param3='" + param3 + '\'' +
                    '}';
        }
    }
}
