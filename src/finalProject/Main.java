package finalProject;

import finalProject.controller.HotelController;
import finalProject.controller.OrderController;
import finalProject.controller.RoomController;
import finalProject.controller.UserController;
import finalProject.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;

public class Main {

    static int errors = 3;
    //findHotelByName(String name)
    //findHotelByCity(String city)
    //Collection findRooms(Filter filter)
    //void bookRoom(long roomId, long userId, long hotelId)
    //void cancelReservation(long roomId, long userId)
    //User registerUser(User user)
    //void login(String userName, String password)
    //void logout()

    public static void main(String[] args) {
        UserController userController = new UserController();
        HotelController hotelController = new HotelController();
        RoomController roomController  = new RoomController();
        OrderController orderController = new OrderController();

        String enteredText = "";

        String menu1 = "Print \"register\" for register; Print \"login\" for login; Print \"exit\" for finish your work;";
        String menu2 = "Select what do you want to do:  \"findHotelByName\" - 1; \"findHotelByCity\" - 2; \"findRooms\" - 3; \"bookRoom\" - 4; \"cancelReservation\" - 5. For finish work print \"exit\"";
        String countryMsg = "Print country name: ";
        String loginMsg = "Print login (min - 8 characters, max - 16): ";
        String passwordMsg1 = "Print password (min - 8 characters, max - 16): ";
        String passwordMsg2 = "Repeat your password: ";
        String logout = "Logout complete successful";
        String findHotelByName = "Print hotel name you would like to find";
        String findHotelByCity = "Print the city name";
        User user = null;

        try (BufferedReader inputStreamReader = new BufferedReader( new InputStreamReader(System.in))){
            printMsg(menu1);
            enteredText = inputStreamReader.readLine();

            while (!enteredText.equals("exit")) {
            //regisration
                if (enteredText.equals("register")) {
                    printMsg(countryMsg);
                    String country = inputStreamReader.readLine();
                    printMsg(loginMsg);
                    String login = inputStreamReader.readLine();
                    while (!validate(login, 8, 16)){
                        login = inputStreamReader.readLine();
                    }
                    printMsg(passwordMsg1);
                    String password1 = inputStreamReader.readLine();
                    while (!validate(password1, 8, 16)){
                        password1 = inputStreamReader.readLine();
                    }
                    printMsg(passwordMsg2);
                    String password2 = inputStreamReader.readLine();
                    while (!comparePass(password1, password2, 8, 16)){
                        password2 = inputStreamReader.readLine();
                    }
                    user = new User(login, password1, country, UserType.USER);
                    if (userController.registerUser(user) == null){
                        System.out.println("Can't register user");
                    }else {
                        System.out.println("Registration was complete");
                        printMsg(menu2);
                        enteredText = inputStreamReader.readLine();
                    }
                    printMsg(menu2);
            //login
                }else if (enteredText.equals("login") || enteredText.equals("exit")) {
                    printMsg(loginMsg);
                    String login = "";
                    String password = "";
                    while((login == "" && password == "") || user == null) {
                        login = inputStreamReader.readLine();
                        while (!validate(login, 8, 16)) {
                            login = inputStreamReader.readLine();
                        }
                        printMsg(passwordMsg1);
                        password = inputStreamReader.readLine();
                        while (!validate(password, 8, 16)) {
                            password = inputStreamReader.readLine();
                        }
                        user = userController.loginUser(login, password);
                        if (user != null) {
                            System.out.println("Login was complete");
                            printMsg(menu2);
                            enteredText = inputStreamReader.readLine();
                        }else{
                            login = "";
                            password = "";
                            Main.errors--;
                            checkErrors();
                            printMsg(loginMsg);
                        }
                    }
            //logout
                }else if(enteredText.equals("logout")){
                    user = userController.logout();
                    printMsg(logout);
                    System.exit(1);
            //find hotel by name
                }else if (enteredText.equals("1")) {
                    printMsg(findHotelByName);
                    enteredText = inputStreamReader.readLine();
                    System.out.println(hotelController.findHotelByName(enteredText).toString());
                    printMsg(menu2);
                    enteredText = inputStreamReader.readLine();
            //find hotel by city
                }else if (enteredText.equals("2")) {
                    printMsg(findHotelByCity);
                    enteredText = inputStreamReader.readLine();
                    System.out.println(Arrays.deepToString(hotelController.findHotelByCity(enteredText).toArray()));
                    printMsg(menu2);
                    enteredText = inputStreamReader.readLine();
            //find find hotels by city
                }else if (enteredText.equals("3")) {
            //find rooms
                printMsg("Print amount of quests:");
                String guestsNumber = inputStreamReader.readLine();
                int guestsAmountFilter = parseStringToInt(guestsNumber);
                while(guestsAmountFilter <= 0) {
                    guestsNumber = inputStreamReader.readLine();
                    guestsAmountFilter = parseStringToInt(guestsNumber);
                }
                printMsg("Print average price per night for room");
                String averagePrice = inputStreamReader.readLine();
                int priceFilter = parseStringToInt(averagePrice);
                while(guestsAmountFilter <= 0) {
                    averagePrice = inputStreamReader.readLine();
                    priceFilter = parseStringToInt(averagePrice);
                }
                printMsg("Would you like room with breakfast? Choose: Y/N");
                String bftIncluded = inputStreamReader.readLine();
                while(!checkYesNotStatus(bftIncluded)){
                    bftIncluded = inputStreamReader.readLine();
                }
                boolean breakfastFilter = parseStringToBoolean(bftIncluded);
                printMsg("Would you like room with permission for pets? Choose: Y/N");
                String petsAllowed = inputStreamReader.readLine();
                while(!checkYesNotStatus(petsAllowed)){
                    petsAllowed = inputStreamReader.readLine();
                }
                boolean petsFilter = parseStringToBoolean(petsAllowed);
                printMsg("Print date would you like to in? Format: \"dd-MM-yyyy\"");
                String dateAvailableFrom = inputStreamReader.readLine();
                Date dateAvailableFromFilter = Utils.StringToDate(dateAvailableFrom);
                while(dateAvailableFromFilter == null){
                    dateAvailableFrom = inputStreamReader.readLine();
                    dateAvailableFromFilter = Utils.StringToDate(dateAvailableFrom);
                }
                printMsg("Print country where would you like to stay");
                String countryFilter = inputStreamReader.readLine();
                printMsg("Print city where would you like to stay");
                String cityFilter = inputStreamReader.readLine();
                Filter filter = new Filter(guestsAmountFilter, priceFilter, breakfastFilter, petsFilter, dateAvailableFromFilter, countryFilter, cityFilter);
                printMsg("Print city where would you like to stay");
                printMsg("Rooms by next parametrs:");
                printMsg("Guests amount: " + guestsAmountFilter + "; price: " + priceFilter + " +-100 UAH; " + " breakfastFilter: " + breakfastFilter + "; petsFilter: " + petsFilter + "; date from: " + dateAvailableFromFilter + "; country: " + countryFilter + "; city: " + cityFilter + ".");
                System.out.println(Arrays.deepToString(roomController.findRooms(filter).toArray()));
                printMsg(menu2);
                enteredText = inputStreamReader.readLine();
            //book room
                }else if (enteredText.equals("4")) {
                if(user == null){
                    printMsg("Error! You've must been logined.");
                    printMsg(menu1);
                    enteredText = inputStreamReader.readLine();
                }
                printMsg("Select parameters for book the room: ");
                printMsg("Print a room ID:");
                String roomIdString = inputStreamReader.readLine();
                long roomId = parseStringToLong(roomIdString);
                Room room = null;
                while(room == null) {
                    if(roomId > 0){
                        room = roomController.findRoomById(roomId);
                        if(room == null){
                            Main.errors--;
                            checkErrors();
                            printMsg("Error! Couldn't find a room. Try again");
                        }
                        break;
                    }
                    roomIdString = inputStreamReader.readLine();
                    roomId = parseStringToLong(roomIdString);
                }
                printMsg("Print a hotel ID:");
                String hotelIdString = inputStreamReader.readLine();
                long hotelId = parseStringToLong(hotelIdString);
                Hotel hotel = null;
                while(hotel == null) {
                    if (hotelId > 0) {
                        hotel = hotelController.findHotelById(hotelId);
                        if (hotel == null) {
                            Main.errors--;
                            checkErrors();
                            printMsg("Error! Couldn't find a hotel. Try again");
                        }
                        break;
                    }
                    hotelIdString = inputStreamReader.readLine();
                    hotelId = parseStringToLong(hotelIdString);
                }
                orderController.bookRoom(roomId, hotelId, user.getId());
                printMsg(menu2);
                enteredText = inputStreamReader.readLine();
            //cancel reservation
                }else if (enteredText.equals("5")) {
                    if(user == null){
                        printMsg("Error! You've must been logined.");
                        printMsg(menu1);
                        enteredText = inputStreamReader.readLine();
                    }
                    printMsg("Select parameters for cancel the reservation of the room: ");
                    printMsg("Print a room ID:");
                    String roomIdString = inputStreamReader.readLine();
                    long roomIdforCancel = parseStringToLong(roomIdString);
                    orderController.cancelReservation(roomIdforCancel, user.getId());
                    printMsg(menu2);
                    enteredText = inputStreamReader.readLine();
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.err.println("Reading from keyboard failed");
        }

    }

    private static void printMsg(String msg){
        System.out.println(msg);
    }

    private static boolean validate (String text, int min, int max){
        if(text.length() < min || text.length() > max){
            System.out.println("Try again");
            Main.errors--;
            return false;
        }
        checkErrors();
        return true;
    }

    private static boolean comparePass (String pass1, String pass2, int min, int max){
        if(pass2.length() < min || pass2.length() > max || !pass1.equals(pass2)){
            System.out.println("Try again");
            Main.errors--;
            return false;
        }
        checkErrors();
        return true;
    }

    private static void checkErrors(){
        if(Main.errors <= 0){
            System.out.println("Trying amount exceeded.");
            System.exit(1);
        }
    }

    private static int parseStringToInt(String s){
        int result = 0;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            Main.errors--;
            checkErrors();
            printMsg("Error! Try again. Print number");
        }
        return result;
    }

    private static long parseStringToLong(String s){
        long result = 0;
        try {
            result = Long.parseLong(s);
        } catch (NumberFormatException ex) {
            Main.errors--;
            checkErrors();
            printMsg("Error! Try again. Print number");
        }
        return result;
    }

    private static double parseStringToDouble(String s){
        double result = 0;
        try {
            result = Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            Main.errors--;
            checkErrors();
            printMsg("Error! Try again. Print number");
        }
        return result;
    }

    private static boolean parseStringToBoolean(String s){
        if(s.equals("Y")){
            return true;
        }
        return false;
    }

    private static boolean checkYesNotStatus(String s){
        while(s.equals("Y") || s.equals("N")){
            return true;
        }
        System.out.println("Try again");
        Main.errors--;
        checkErrors();
        return false;

    }

}
