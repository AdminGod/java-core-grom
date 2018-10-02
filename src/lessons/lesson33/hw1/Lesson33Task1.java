package lessons.lesson33.hw1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Lesson33Task1 {

    public static void writeToFileFromConsole(String path) throws FileNotFoundException {
        //check if file exists
        validate(path);

        System.out.println("Enter file content to write: ");

        String content = read();
        write(content, path);
    }

    private static String read(){
        BufferedReader inputStreamReader = new BufferedReader( new InputStreamReader(System.in));
        String consoleData = null;
        try {
            String enteredText = inputStreamReader.readLine();

            //collect printed data
            while(!enteredText.equals("wr")) {
                consoleData += "\r\n" + enteredText;
                enteredText = inputStreamReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(inputStreamReader);
        }
        return consoleData;
    }

    private static void write(String consoleData, String path){
        PrintWriter writer = null;

        StringBuffer backUp = readFromFile(path);
        try {
            writer = new PrintWriter(new FileWriter(path, true));
            writer.append("\r\n" + consoleData);
        } catch (IOException e) {
            System.err.println("We can't write to file!");
            try (PrintWriter printWriterBackUp = new PrintWriter(new FileWriter(path, false))) {
                printWriterBackUp.append(backUp);
            } catch (IOException IOEx) {
                System.err.println("We can't backUp file!");
            }

        } finally {
            IOUtils.closeQuietly(writer);
        }
    }


    private static void validate(String path) throws FileNotFoundException {
        File file = new File(path);
        if(!file.exists()){
            System.out.println("File with path " + path + " not found");
            throw new FileNotFoundException();
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
}
