package finalProject;

import finalProject.controller.HotelController;
import finalProject.controller.RoomController;
import finalProject.controller.UserController;
import finalProject.model.User;
import finalProject.model.UserType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

        String enteredText = "";

        String menu1 = "Print \"register\" for register; Print \"login\" for login; Print \"exit\" for finish your work;";
        String menu2 = "Select what do you want to do:  \"findHotelByName\" - 1; \"findHotelByCity\" - 2; \"findRooms\" - 3; \"bookRoom\" - 4; \"cancelReservation\" - 5. For finish work print \"exit\"";
        String countryMsg = "Print country name: ";
        String loginMsg = "Print login (min - 8 characters, max - 16): ";
        String passwordMsg1 = "Print password (min - 8 characters, max - 16): ";
        String passwordMsg2 = "Repeat your password: ";
        String logout = "Logout complete successful";
        String findHotelByName = "Print hotel name you would like to find";
        String findHotelByCity = "Print city in which you would like to find a hotel";

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
                //find find rooms by city
                }else if (enteredText.equals("3")) {

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

}
