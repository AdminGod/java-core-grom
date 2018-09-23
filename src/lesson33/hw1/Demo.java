package lesson33.hw1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Demo {

    public static void main(String[] args) {
        String path = "E:\\MEGA\\PT\\java-core-grom_fixed\\test3.txt";
        writeToFileFromConsole(path);
    }


    public static void writeToFileFromConsole(String path){


        BufferedReader inputStreamReader = new BufferedReader( new InputStreamReader(System.in));
        FileWriter fileWriter = null;
        PrintWriter writer = null;

        System.out.println("Enter file content to write: ");
        try {
            String enteredText = inputStreamReader.readLine();
            String consoleData = null;
            //collect printed data
            while(!enteredText.equals("wr")) {
                consoleData += "\r\n" + enteredText;
                enteredText = inputStreamReader.readLine();
            }
            //check if file exists
            validate(path);
            //write printed data to file @path@
            try {
                fileWriter = new FileWriter(path, true);
                writer = new PrintWriter(fileWriter);
                writer.append("\r\n" + consoleData);
            } catch (IOException e) {
                System.err.println("We can't write to file!");
            } finally {
                IOUtils.closeQuietly(fileWriter);
                IOUtils.closeQuietly(writer);
            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(inputStreamReader);
        }
    }

    private static void validate(String path){
        FileReader reader;
        try {
            reader = new FileReader(path);
        }catch (FileNotFoundException ex){
            System.out.println("File with path " + path + " not found");
            return;
        }
    }
}
