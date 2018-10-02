package lessons.lesson34.hw3;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Solution {

    //copy by File.io methods
    public static void copyFileContent(String pathFileFrom, String pathFileTo){
        File fileFrom = new File(pathFileFrom);
        File fileTo = new File(pathFileTo);

        validate(pathFileFrom, fileFrom);
        validate(pathFileTo, fileTo);

        StringBuilder content = readFromFileByFileMethods(pathFileFrom, fileFrom);
        writeToFileByFileMethods(content, pathFileTo, fileTo);
    }

    public static StringBuilder readFromFileByFileMethods(String path, File file){
        StringBuilder result = new StringBuilder();

        try(FileInputStream fileInputStream = new FileInputStream(file)){
            int content;
            while ((content = fileInputStream.read()) != -1){
                result.append((char) content);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + path + " doesn't exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }
        return result;
    }

    public static void writeToFileByFileMethods(StringBuilder content, String path, File file){
        StringBuilder backUp = readFromFileByFileMethods(path, file);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
            fileOutputStream.write(content.toString().getBytes());
        } catch (FileNotFoundException e) {
            System.err.println("File " + path + " doesn't exist");
        } catch (IOException e) {
            try (PrintWriter printWriterBackUp = new PrintWriter(new FileWriter(path, false))) {
                printWriterBackUp.append(backUp);
            } catch (IOException IOEx) {
                System.err.println("We can't backUp file!");
            }
            System.err.println("Reading from file  " + path + " failed");
        }
    }

    public static void validate(String path, File file){
        //validate existing
        if(!file.exists()){
            System.err.println("File " + path + " doesn't exist");
            System.exit(1);
        }
        //validate reading
        if(!file.canRead()){
            System.err.println("File " + path + " doesn't have permission for reading");
            System.exit(1);
        }
        //validate writing
        if(!file.canWrite()){
            System.err.println("File " + path + " doesn't have permission for writing");
            System.exit(1);
        }
    }

    //copy by ApacheIO methods
    public static void copyFileCOntentByApacheIO(String pathFileFrom, String pathFileTo) throws IOException {
        File fileFrom = new File(pathFileFrom);
        File fileTo = new File(pathFileTo);

        validate(pathFileFrom, fileFrom);
        validate(pathFileTo, fileTo);

        String content = readFromFileApacheIO(fileFrom);
        writeToFileApacheIO(content, fileTo);
    }

    public static String readFromFileApacheIO(File file) throws IOException {
        return FileUtils.readFileToString(file);
    }
    public static void writeToFileApacheIO(String content, File file) throws IOException {
        FileUtils.write(file, content);
    }
}
