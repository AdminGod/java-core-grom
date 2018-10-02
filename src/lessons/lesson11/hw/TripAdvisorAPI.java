package lessons.lesson11.hw;

public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public TripAdvisorAPI() {
    }

    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] searchedRooms = new Room[0];
        if(rooms != null) {
            Room[] searchedRoomsTemp = new Room[rooms.length];//expect all array is matching to our params
            int counter = 0;
            for (Room room : rooms) {
                //sort rooms by params
                if (room != null && room.getPrice() == price && room.getPersons() <= (persons + 1) && room.getPersons() >= (persons - 1) && room.getCityName() == city && room.getHotelName() == hotel) {
                    searchedRoomsTemp[counter] = room;
                    counter++;
                }
            }
            searchedRooms = new Room[counter];
            if (counter != 0) {
                //delete from temp array null items
                for (int i = 0; i < counter; i++) {
                    searchedRooms[i] = searchedRoomsTemp[i];
                }
            }
        }
        return searchedRooms;
    }

    public Room[] getAll() {
        Room[] allRooms= new Room[0];
        if(rooms != null) {
            Room [] allRoomsTemp = new Room[rooms.length];
            int counter = 0;
            for (Room room : rooms) {
                //sort rooms by params
                if (room != null) {
                    allRoomsTemp[counter] = room;
                    counter++;
                }
            }
            allRooms = new Room[counter];
            if(counter > 0) {
                for (int i = 0; i < counter; i++) {
                    allRooms[i] = allRoomsTemp[i];
                }
            }
        }

        return allRooms;
    }
}
