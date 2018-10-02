package lessons.lesson19.hw;

public class Demo {
    public static void main(String[] args) {
        File f1 = null;
        File f2 = null;
        File f3 = null;
        File f4 = null;
        File f5 = null;
        File f6 = null;
        File file1 = null;
        File file2 = null;
        File file3 = null;
        File file4 = null;
        File f7 = null;
        File f8 = null;
        try {
            f1 = new File(1, "f1", ".txt", 10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            f2 = new File(2, "f2", ".txt", 10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            f3 = new File(3, "f3", ".txt", 10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            f4 = new File(4, "f4", ".doc", 10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            f5 = new File(5, "f5", ".doc", 10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            f6 = new File(6, "f6", ".txt", 10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            file1 = new File(5, "file", ".txt", 8);//ok
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            file2 = new File(5, "fileeee", ".txt", 8);//too long name;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            file3 = new File(5, "file", ".prd", 8);//not aceptable format
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            file4 = new File(3, "file", ".doc", 20);//not enough space
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            f7 = new File(12, "test7", ".txt", 150);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            f8 = new File(13, "test8", ".java", 1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        File[] files1 = new File[5];
        files1[0] = f1;
        files1[3] = f2;
        files1[4] = f3;



        File[] files2 = new File[5];
        files2[1] = f4;
        files2[2] = f5;
        files2[3] = f6;

        String [] formats = {".txt", ".doc", ".docx"};

        Storage s1 = new Storage(1, files1, formats, "UA", 50);
        Storage s2 = new Storage(2, files2, formats, "USA", 50);

        Controller controller = new Controller();
        //check put method

        File file5 = null;//send file null to put method
        Storage s3 = null;//send storage null to put method

        File [] files = s1.getFiles();

        //Sys.out.println((files == s1.getFiles()) + " - " + (files.equals(s1.getFiles())));

/**
        try {
            //controller.put(s3, file4);
            //controller.put(s3, file4);
            controller.put(s2, file4);
        } catch (Exception e) {
            Sys.out.println(e.getMessage());
        }

        //check delete method

        try {
            controller.delete(s2, f5);//normaly removed
            //controller.delete(s2, f5);//File not found exception
            //controller.delete(s2, null);send nulls to method
            //controller.delete(null, null);//send nulls to method
        } catch (Exception e) {
            Sys.out.println(e.getMessage());
        }

        //check transfer all
        Storage s4 = new Storage(4, files1, new String []{".mp3", ".mp4"}, "Canada", 60);

        try {
            controller.transferAll(s1, s2);//normally transfer
            //controller.transferAll(null, null);//send nulls to method transferAll
            //controller.transferAll(s1, null);//send nulls to method transferAll
            //controller.transferAll(null, s2);//send nulls to method transferAll
            //controller.transferAll(s2, s4);//catch not format aceptable exception
        }catch (Exception e){
            Sys.out.println(e.getMessage());
        }
*/
        //check transfer file method


        Storage s5 = new Storage(7, new File[]{f7}, formats, "Croatia", 1000);
        Storage s6 = new Storage(8, new File[]{f8}, formats, "Croatia", 1000);
        try {
            //controller.transferFile(s2, s1, 1);//catch file not found exception
            controller.transferFile(s1, s2, 3);//normally transfer
            //controller.transferFile(s5, s1, 12);//catch there is not enough space in next storage
            //controller.transferFile(s6, s1, 13);//catch Illeagal format exception
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
