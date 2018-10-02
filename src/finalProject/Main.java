package finalProject;

import finalProject.controller.UserController;
import finalProject.model.User;
import finalProject.model.UserType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

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

        String consoleData = null;
        try (BufferedReader inputStreamReader = new BufferedReader( new InputStreamReader(System.in))){
            System.out.println("Print \"1\" for register; Print \"2\" for login; Print \"exit\" for finish your work;");
            String enteredText = inputStreamReader.readLine();
            //work while won't press exit from the program
            while(!enteredText.equals("exit")) {
                if(enteredText.equals("1")) {
                    User user = getPrintedDataFromRegistration();
                    if(user != null) {
                        userController.registerUser(user);
                    }
                }
                return;
                //System.out.println("Print \"1\" for register; Print \"2\" for login; Print \"exit\" for finish your work;");
                //enteredText = inputStreamReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }
    }

    private static User getPrintedDataFromRegistration (){
        User user = null;
        int errors = 3;
        String country = getPrintedData("Print country name: ");
        String login = getPrintedData("Print login (min - 8 characters, max - 16): ");
        String pass1 = getPrintedData("Print password (min - 8 characters, max - 16): ");
        String pass2 = "";
        while (errors > 0) {
            pass2 = getPrintedData("Repeat your password: ");
            if(pass1.equals(pass2)){
                return new User(country, login, pass1, UserType.USER);
            }
            errors--;
        }
        System.err.println("Trying amount exceeded");
        return null;
    }

    private static String getPrintedData(String msg){
        int errors = 3;
        String data = "";
        try (BufferedReader inputStreamReaderReg = new BufferedReader( new InputStreamReader(System.in))){
            while (errors > 0) {
                System.out.println(msg);
                data = inputStreamReaderReg.readLine();
                if (data.length() >= 8 && data.length() <= 16) {
                    break;
                }
                errors--;
            }
            if (errors <= 0 ){
                System.err.println("Trying amount exceeded");
                return "";
            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }
        return data;
    }


}
