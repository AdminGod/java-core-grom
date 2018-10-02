package lessons.lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Date;

public class ReadWriteFile {
    public static void main(String[] args) {
        String path1 = new String("E:\\MEGA\\PT\\java-core-grom_fixed\\test1.txt");
        String path2 = new String("E:\\MEGA\\PT\\java-core-grom_fixed\\test3.txt");
        /**
        File file = new File("test3.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        //readFile(path1);
        //writeFile(path2);
        writeFile22(path2);
    }

    private static void readFile (String path) {

        FileReader reader;
        try {
            reader = new FileReader(path);

        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist!");
            return;
        }

        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ( (line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + "E:\\MEGA\\PT\\test.txt" + " failed");
        }
        finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
    }

    private static void writeFile(String path){
        FileWriter writer = null;
        PrintWriter printWriter = null;
        try {
            writer = new FileWriter(path, true);

            printWriter = new PrintWriter(writer);

            for(int i = 0; i < 10; i++) {
                printWriter.append("\r\n" + i + " - tra ta ta ....22222222");
            }
        } catch (IOException e) {
            System.err.println("We can't write to file!");
            return;
        } finally {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(printWriter);
        }
    }

    static void writeFile22(String path){
        FileWriter writer = null;
        BufferedWriter printWriter = null;
        try {
            writer = new FileWriter(path, true);
            printWriter = new BufferedWriter(writer);

            printWriter.append("\r\n");
            printWriter.append("1"+new Date());
        } catch (IOException e) {
            System.err.println("We can't write to file!");
        } finally {

        }
    }
}
