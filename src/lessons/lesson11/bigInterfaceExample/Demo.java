package lessons.lesson11.bigInterfaceExample;

public class Demo {

    public static void main(String[] args) {
        File file1 = new File("test.txt", "C:/user/home", "txt", 11);
        File file2 = new File("test.txt", "C:/user/home", "txt", 11);
        File file3 = new File("video", "C:/user/home", "txt", 11);
        //File file4 = new File("test.txt", "C:/user/home", "txt", 11);
        File file5 = new File("myhome", "C:/user/home", "jpg", 120);

        File [] files = {file1, file2, file3, null, file5};
        Storage storage = new Storage(files);

        FileReader fileReader = new FileReader();
        SimpleReader simpleReader = new SimpleReader();

        read(storage, fileReader);
        read(storage, simpleReader);

        //testing
        System.out.println("testing");
        //fileReader.findMaxSizeFile

        fileReader.readFilesFromStorage(null);//storage = null

        File [] files1 = new File[5];
        Storage s = new Storage(files1);
        FileReader fileReader1 = new FileReader();
        fileReader1.readFilesFromStorage(s);//read from null array of files
        fileReader.readFilesFromStorage(storage);//read file from storage where is an array with files

    }

    private static void read (Storage storage, Readable readable){
        System.out.println("method is starting");
        readable.readFilesFromStorage(storage);
    }
}
