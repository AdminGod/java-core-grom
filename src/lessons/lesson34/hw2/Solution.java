package lessons.lesson34.hw2;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        validate(fileFromPath, fileFrom);
        validate(fileToPath, fileTo);

        String sentences = readFromFile(fileFromPath).toString();
        String[] arrSentences = sentences.split("\\.");
        LinkedList<String> sentencesFromFile = new LinkedList<>(Arrays.asList(arrSentences));

        writeToFile(fileToPath, searchAndGetSentences(sentencesFromFile, word), true);

        writeToFile(fileFromPath, prepareLeftSentences(sentencesFromFile), false);
    }

    public static void validate(String filePath, File file){
        //validate if files exists
        if(!file.exists()){
            System.err.println("File " + filePath + " doesn't exist");
            System.exit(1);
        }
        //validate if file can be read
        if(!file.canRead()){
            System.err.println("File " + filePath + " doesn't have permission for reading");
            System.exit(1);
        }
        //validate if can we write to file
        if(!file.canWrite()){
            System.err.println("File " + filePath + " doesn't have permission for writing");
            System.exit(1);
        }
    }

    private static StringBuilder readFromFile(String path){
        StringBuilder res = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ( (line = br.readLine()) != null) {
                res.append(line);
            }
        }catch (IOException ioEx){
            System.err.println("Reading from file " + path + " failed");
            System.exit(1);
        }
        return res;
    }

    //if @rewrite=true - we add some text to file, @rewrite=false - we rewrite content with new text
    private static void writeToFile(String path, StringBuilder content, boolean rewrite){
        StringBuilder backUp = readFromFile(path);
        try(PrintWriter printWriter =  new PrintWriter(new FileWriter(path, rewrite))){
            printWriter.append(content + "\r\n");
        }catch (IOException IOex){
            try (PrintWriter printWriterBackUp = new PrintWriter(new FileWriter(path, false))) {
                printWriterBackUp.append(backUp);
            } catch (IOException IOEx) {
                System.err.println("We can't backUp file!");
            }
            System.err.println("We can't write to file!");
        }
    }

    private static StringBuilder searchAndGetSentences(LinkedList<String> sentences, String word){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < sentences.size(); i++){
            String sentence = sentences.get(i);
            if(sentence.length() > 10 && sentence.contains(word)){
                result.append(sentence + "\r\n");
                sentences.remove(i);
                i--;
            }
        }
        return result;
    }

    private static StringBuilder prepareLeftSentences(LinkedList<String> leftSentences){
        StringBuilder result = new StringBuilder();

        for (String sentence : leftSentences){
            result.append(sentence + "\r\n");
        }
        return result;
    }
}
