package lessons.lesson15.hw2;

public class Controller {

    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }



    public Room[] requestRooms(int price, int persons, String city, String hotel){

        int lengthOfTotalResultArray = 0;
        if(apis!= null) {
            Room[][] tempResult = new Room[apis.length][];
            for (int i = 0; i < apis.length; i++) {
                if(apis[i] != null) {
                    tempResult[i] = apis[i].findRooms(price, persons, city, hotel);
                    if (tempResult[i] != null) {
                        lengthOfTotalResultArray += tempResult[i].length;
                    }
                }
            }
            //new empty Total Result Array
            Room[] totalResult = new Room[lengthOfTotalResultArray];
            int position = 0;
            //join all arrays to one (copy >>>> past)
            for (int i = 0; i < tempResult.length; i++) {
                if (tempResult[i] != null) {
                    System.arraycopy(tempResult[i], 0, totalResult, position, tempResult[i].length);
                    position += tempResult[i].length;
                }
            }
            return totalResult;
        }
        return null;
    }

    public Room[] check(API api1, API api2){

        if(api1 != null && api2 == null){
            return getRoomsFromAPI(api1);
        }
        if(api2 != null && api1 == null){
            return getRoomsFromAPI(api2);
        }
        if(api1 == null && api2 == null){
            return new Room[0];
        }

        Room[] rooms1 = api1.getAll();
        Room[] rooms2 = api2.getAll();
        //cont
        int counter = 0;
        for(Room a : rooms1){

            for(Room b : rooms2){
                if((a != null) && (a.equals(b))){
                    counter++;
                }
            }
        }
        //REMOVE
        Room[] result = new Room[counter];
        for(Room a : rooms1){
            int position = 0;
            for(Room b : rooms2){
                if(a != null && a.equals(b)){
                    result[position] = a;
                    position++;
                }
            }
        }
        return result;
    }
    private Room[] getRoomsFromAPI(API api){
        Room[] rooms = api.getAll();
        int counter = 0;
        for (Room a: rooms){
            if(a != null){
                counter++;
            }
        }
        Room[] result = new Room[counter];
        int position = 0;
        for (Room a: rooms){
            if(a != null){
                result[position] = a;
                position++;
            }
        }
        return result;
    }
}
