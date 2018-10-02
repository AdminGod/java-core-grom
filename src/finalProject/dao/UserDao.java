package finalProject.dao;

import finalProject.model.User;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class UserDao {



    //reading data - reading file
    //data processing - mapping data
    public User registerUser (User user){
        getUserByLogin("adminLog2");
        //save user to db (file)
        return null;
    }

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
    //
    public String getUserByLogin(String login) {
        String DBpath = "E:\\MEGA\\PT\\java-core-grom_fixed\\src\\finalProject\\UserDb.txt";
        File file = new File(DBpath);

        validate(DBpath, file);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ( (line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from db failed");
        }
        return null;
    }

    public void writeToFileApacheIO(String content, File file) throws IOException {
        FileUtils.write(file, content);
    }
}
