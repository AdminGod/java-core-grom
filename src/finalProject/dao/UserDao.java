package finalProject.dao;

import finalProject.model.User;
import finalProject.model.UserType;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserDao extends Dao {

    private final static String DBPATH = "E:\\MEGA\\PT\\java-core-grom_fixed\\src\\finalProject\\UserDb.txt";


    //reading data - reading file
    //data processing - mapping data
    public User registerUser (User user) {
        if(getUserByLogin(user.getUserName()) == null){
            return save(user);
        }
        return null;
    }
    //para 0 - id, 1 - login, 2 password, 3 - country, 4 role
    public User getUserByLogin(String login) {

        validate(UserDao.DBPATH, new File(UserDao.DBPATH));

        ArrayList<String> responseFromDB = Dao.findByName(login, UserDao.DBPATH);
        if(responseFromDB != null && responseFromDB.size() > 0){
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
    /**
    public void validate(String path, File file){
        //validate existing
        if(!file.exists()){
            System.err.println("DB " + path + " doesn't exist");
            System.exit(1);
        }
        //validate reading
        if(!file.canRead()){
            System.err.println("DB " + path + " doesn't have permission for reading");
            System.exit(1);
        }
        //validate writing
        if(!file.canWrite()){
            System.err.println("DB " + path + " doesn't have permission for writing");
            System.exit(1);
        }
    }
    */
    /**
    public long generateID(){
        File file = new File(UserDao.DBPATH);

        validate(UserDao.DBPATH, file);
        long id = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String user = "";
            String line;
            while ( (line = br.readLine()) != null) {
                if(line.length() > 0){
                    user = line;
                }
            }
            id = new Long(user.split(", ")[0]);
        } catch (IOException e) {
            System.err.println("Reading from db failed");
        }
        return id += 1;
    }
     */

    private User save (User user){
        File file = new File(UserDao.DBPATH);
        validate(UserDao.DBPATH, file);
        user.setId(Dao.generateID(UserDao.DBPATH));
        try {
            FileUtils.write(file, "\r\n" + user.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
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
