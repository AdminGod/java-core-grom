package lessons.lesson11.hw;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    //some notes for second commit
    public static void main(String[] args) {
        Room[] rooms1 = new Room[5];

        int [] arr1 = {0, 5, 65, 1};
        int [] arr2 = {0, 5, 6535, 1};

        int [] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        for(int a : result){
            int counter = 0;
            for(int b : result){
                if(a == b){
                    result[counter] = 0;
                    counter ++;
                }
            }
        }

        //testing

        //BookingComAPI.find rooms
        Room room1 = new Room(12, 2000, 2, new Date(), "Plaza", "Kiev");
        Room room2 = new Room(11, 1000, 1, new Date(), "Plaza", "Kiev");
        Room room4 = new Room(10, 23000, 3, new Date(), "Plaza", "Kiev");
        Room room3 = new Room(11, 1000, 1, new Date(), "Plaza", "Kiev");
        Room[] rooms = new Room[5];
        rooms[0] = room2;
        rooms[3] = room1;
        Room[] rooms2 = null;
        Room[] rooms3 = new Room[4];
        Room[] rooms4 = new Room[4];

        rooms4[2] = room4;
        BookingComAPI booking1 = new BookingComAPI(rooms);
        BookingComAPI booking2 = new BookingComAPI(rooms2);
        BookingComAPI booking3 = new BookingComAPI(rooms3);

        Room[] result1 = booking1.findRooms(1000, 1, "Kiev", "Plaza");//found with requested parameters;
        System.out.println(Arrays.deepToString(result1));
        Room[] result2 = booking1.findRooms(100, 2, "Kiev", "Plaza");//not found
        System.out.println(Arrays.deepToString(result2));
        Room[] result3 = booking2.findRooms(100, 2, "Kiev", "Plaza");//seach by rooms = null
        System.out.println(Arrays.deepToString(result3));
        Room[] result4 = booking3.findRooms(100, 2, "Kiev", "Plaza");//search by rooms where only empty elements
        System.out.println(Arrays.deepToString(result4));

        Room[] allRooms1 = booking1.getAll();
        Room[] allRooms2 = booking2.getAll();
        Room[] allRooms3 = booking3.getAll();

        API api1 = new BookingComAPI(rooms);
        API api2 = new BookingComAPI(rooms4);
        API api3 = null;
        API []apis = {api1, api2, null};
        Controller controller = new Controller(apis);
        //testing COntroller.requestRooms
        Room[] requestedRooms = controller.requestRooms(2000, 2, "Kiev", "Plaza");//requested rooms from not null by some parameters
        System.out.println(Arrays.deepToString(requestedRooms));
        API [] apis2 = null;
        Controller controller1 = new Controller(null);
        Room[] requestedRooms2 = controller1.requestRooms(2000, 2, "Kiev", "Plaza");//request rooms where apis = null
        System.out.println(Arrays.deepToString(requestedRooms2));
        Room[] requestedRooms3 = controller.requestRooms(2000, 4, "Kiev", "Plaza");//request rooms where but result is empty, not found with matchesnull
        System.out.println(Arrays.deepToString(requestedRooms3));


        //testing Controller.check
        Room[] checkRooms = controller.check(api1, api2);//check 2 api with not equal rooms, return new Room[0];
        System.out.println(Arrays.deepToString(checkRooms));
        Room[] checkRooms2 = controller.check(api3, api2);//check if one api == null
        System.out.println(Arrays.deepToString(checkRooms2));
        Room[] checkRooms3 = controller.check(api3, api3);//check if both api == null
        System.out.println(Arrays.deepToString(checkRooms3));

        String s = "";
    }
}
