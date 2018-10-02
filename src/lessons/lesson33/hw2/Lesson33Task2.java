package lessons.lesson33.hw2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Lesson33Task2 {

    public static void readFileByConsolePath()throws Exception{
        String path = readPath();
        validate(path);
        print(path);
    }

    private static void validate(String path) throws Exception {
        File file = new File(path);
        validateIfExist(path, file);
        validateIfCanRead(path, file);
    }

    private static void validateIfExist(String path, File file) throws FileNotFoundException {

        if(!file.exists()){
            System.err.println("File with path " + path + " not found");
            System.exit(1);
        }
    }

    private static void validateIfCanRead(String path, File file) throws Exception {
        if(!file.canRead()){
            System.err.println("File with path " + path + " can't be read");
            throw new Exception();
        }
    }

    private static String readPath(){
        BufferedReader inputStreamReader = new BufferedReader( new InputStreamReader(System.in));
        String path = "";
        try {
            path = inputStreamReader.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(inputStreamReader);
        }
        return path;
    }

    private static void print(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            String line;
            while ( (line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Can't read file by path " + path);
        }
        finally {
            IOUtils.closeQuietly(br);
        }
    }
}
