package finalProject.dao;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dao <T>{

    public static String save(String obj, String path){
        write("\r\n" + obj, true, path);
        return obj;
    }

    public static ArrayList<String> getAll(String path){
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while ( (line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from db failed");
        }
        return result;
    }

    public static ArrayList<String> findByParam(String name, int param, String path){
        return findBy(name, param, path);
    }

    public static ArrayList<String> findByName(String name, String path){
        return findBy(name, 1, path);
    }

    public static ArrayList<String> findById(long id, String path){
        return findBy(Long.toString(id), 0, path);
    }

    private static ArrayList<String> findBy (String param, int column, String path){
        File file = new File(path);
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ( (line = br.readLine()) != null) {
                String [] objectFromDB = line.split(", ");
                if(objectFromDB.length < column){
                    continue;
                }
                String objectNameFromDBparam = objectFromDB[column];
                if(param.equals(objectNameFromDBparam)){
                    result.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Reading from db failed");
        }
        return result;
    }

    public static void update(String obj, String path){
        ArrayList<String> allData = getAll(path);
        ArrayList<String> backUp = new ArrayList<>(allData);

        String[]params = obj.split(", ");
        String objId = params[0];

        for(int i = 0; i < allData.size(); i++){
            String[] paramsS = allData.get(i).split(", ");
            if(paramsS.length == 0){
                continue;
            }
            if(paramsS[0].equals(objId)){
                allData.set(i, obj);
            }
        }
        update(String.join("\r\n", backUp), String.join("\r\n", allData), false, path);
    }

    public static long generateID(String path){
        File file = new File(path);

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
    //rewrite = true - add to the end of file
    private static void write(String content, boolean rewrite, String path){
        File file = new File(path);

        try {
            FileUtils.write(file, content, rewrite);
        } catch (IOException e) {
            System.out.println("Error!!! We couldn't save.");
        }
    }
    //rewrite = false - rewrite the file
    public static void update(String oldContent,String newContent, boolean rewrite, String path){
        File file = new File(path);

        try {
            FileUtils.write(file, newContent, rewrite);
        } catch (IOException e) {
            System.out.println("Error!!! We couldn't save.");
            write(oldContent, false, path);
        }
    }

}
