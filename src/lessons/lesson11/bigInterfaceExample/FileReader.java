package lessons.lesson11.bigInterfaceExample;

public class FileReader implements Readable{

    public void readFilesFromStorage(Storage storage) {
        //find the biggest file
        //show all file's information
        if(storage != null) {
            File maxSizeFile = findMaxSizeFile(storage.getFiles());
            if(maxSizeFile!= null) {
                printFile(findMaxSizeFile(storage.getFiles()));
            }
        }
    }

    private File findMaxSizeFile(File[] files){
        File maxSizeFile = files[0];
        for(File file : files){

            if (file != null && file.getSize() > maxSizeFile.getSize()){
                maxSizeFile = file;
            }
        }
        if(maxSizeFile != null) {
            return maxSizeFile;
        }return null;
    }

    private void printFile(File file){
        System.out.println("Max file will be printed now...");

        System.out.println(file.getName());
        System.out.println(file.getExtension());
        System.out.println(file.getPath());
        System.out.println(file.getSize());
    }
}
