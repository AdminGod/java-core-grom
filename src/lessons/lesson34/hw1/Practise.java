package lessons.lesson34.hw1;

import java.io.*;

public class Practise {

    public static void main(String[] args)throws Exception {
        String pathFrom = "E:\\MEGA\\PT\\java-core-grom_fixed\\test3.txt";
        String pathTo = "E:\\MEGA\\PT\\java-core-grom_fixed\\test1.txt";

        transferFileContent(pathFrom, pathTo);
    }

    public static void transferFileContent(String fileFromPath, String fileToPath)throws Exception{
        //validate
        validate(fileFromPath, fileToPath);
        //read
        StringBuffer content = readFromFile(fileFromPath);
        //write
        writeToFile(fileToPath, content, fileFromPath);
    }

    private static void validate(String fileFromPath, String fileToPath)throws Exception{
        validateIfFileExist(fileFromPath);
        validateIfFileExist(fileToPath);

        validateReadingFromFile(fileFromPath);
        validateReadingFromFile(fileToPath);

        validateWritingToFile(fileFromPath);
        validateWritingToFile(fileToPath);
    }

    private static void validateIfFileExist(String path)throws FileNotFoundException{
        File file = new File(path);
        if(!file.exists()){
            throw new FileNotFoundException("File " + path + " doesn't exist");
        }
    }

    private static void validateReadingFromFile(String path) throws Exception{
        File file = new File(path);
        if(!file.canRead()){
            throw new Exception("File " + path + " doesn't have permission for reading");
        }
    }

    private static void validateWritingToFile(String path)throws Exception {
        File file = new File(path);
        if(!file.canWrite()){
            throw new Exception("File " + path + " doesn't have permission for writing");
        }
    }

    private static StringBuffer readFromFile(String path){
        StringBuffer res = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ( (line = br.readLine()) != null) {
                res.append("\r\n" + line);
            }
        }catch (FileNotFoundException fEx){
            System.err.println("File doesn't exist!");
        }catch (IOException ioEx){
            System.err.println("Reading from file " + path + " failed");
        }
        return res;
    }

    private static void writeToFile(String pathTo, StringBuffer content, String pathFrom){

        StringBuffer backUp =  readFromFile(pathTo);

        try(PrintWriter printWriter =  new PrintWriter(new FileWriter(pathTo, true))){
            printWriter.append("\r\n" + content);
            cleanUpFile(pathFrom);
        }catch (IOException IOex) {
            try (PrintWriter printWriterBackUp = new PrintWriter(new FileWriter(pathTo, false))) {
                printWriterBackUp.append(backUp);
            } catch (IOException IOEx) {
                System.err.println("We can't backUp file!");
            }
        }
    }

    private static void cleanUpFile(String path){
        try(PrintWriter printWriter =  new PrintWriter(new FileWriter(path, false))){
            printWriter.append("");
        }catch (IOException IOex){
            System.err.println("We can't write to file!");
        }
    }
}
