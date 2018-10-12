package finalProject.dao;

import finalProject.model.User;
import finalProject.model.UserType;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserDao extends Dao {

    private final static String DBPATH = "E:\\MEGA\\PT\\java-core-grom_fixed\\src\\finalProject\\UserDb.txt";

    public UserDao() {
        validate(UserDao.DBPATH, new File(UserDao.DBPATH));
    }


    //reading data - reading file
    //data processing - mapping data
    public User registerUser (User user) {
        user.setId(Dao.generateID(UserDao.DBPATH));
        if(getUserByLogin(user.getUserName()) == null){
            return save(user);
        }
        return null;
    }
    //para 0 - id, 1 - login, 2 password, 3 - country, 4 role
    public User getUserByLogin(String login) {

        ArrayList<String> responseFromDB = Dao.findByName(login, UserDao.DBPATH);
        if(responseFromDB.size() > 0){
            return parseStringToUser(responseFromDB.get(0));
        }
        return null;
    }

    public User getUserById(long id) {

        ArrayList<String> responseFromDB = Dao.findById(id, UserDao.DBPATH);
        if(responseFromDB.size() > 0){
            return parseStringToUser(responseFromDB.get(0));
        }
        return null;
    }

    public void writeToFileApacheIO(String content, File file) {
        try {
            FileUtils.write(file, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private User save (User user){
        return parseStringToUser(Dao.save(user.toString(), DBPATH));
    }

    public User loginUser(String login, String password){
        User user = getUserByLogin(login);
        if(user == null){
            System.out.println("User with login " + login + " not found");
            return null;
        }
        if(!user.getPassword().equals(password)){
            System.out.println("Wrong password, try again");
            return null;
        }
        return user;
    }

    private ArrayList<User> parseResponseFromDB(ArrayList<String> response){
        ArrayList<User> result = new ArrayList<>();
        for(String s : response){
            result.add(parseStringToUser(s));
        }
        return result;
    }

    private User parseStringToUser(String string){
        String[] user = string.split(", ");
        return new User(new Long(user[0]), user[1], user[2], user[3], UserType.valueOf(user[4]));
    }
}
