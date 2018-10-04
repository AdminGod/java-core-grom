package finalProject.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dao<T> {

    public static long generateID(String path){
        File file = new File(path);

        validate(path, file);
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

    public static void validate(String path, File file){
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

    public static ArrayList<String> findByParam(String name, int param, String path){
        return findBy(name, param, path);
    }

    public static ArrayList<String> findByName(String name, String path){
        return findBy(name, 1, path);
    }


    public static ArrayList<String> findById(Long id, String path){
        return findBy(id.toString(), 0, path);
    }

    private static ArrayList<String> findBy (String param, int column, String path){
        File file = new File(path);

        validate(path, file);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            ArrayList<String> result = new ArrayList<>();
            String line;
            while ( (line = br.readLine()) != null) {
                String [] objectFromDB = line.split(", ");
                String objectNameFromDBparam = objectFromDB[column];
                if(param.equals(objectNameFromDBparam)){
                    result.add(line);
                }
            }
            return result;
        } catch (IOException e) {
            System.err.println("Reading from db failed");
        }
        return null;
    }



}
