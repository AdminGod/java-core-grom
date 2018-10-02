package lessons.lesson15.equals;


public class Demo {
    public static void main(String[] args) {
        File file1 = new File(111, "home/Documents/test", "txt");
        File file2 = new File(111, "home/Documents/test", "jpg");

        File file3 = new File(111, "home/Documents/test", "txt");//new object, new memory

        File someFile = file1;

        System.out.println(file1.equals(file2));

        System.out.println(file1.hashCode());
        System.out.println(file3.hashCode());
        System.out.println(file1.equals(file3));

        //Sys.out.println(file1.hashCode() == file3.hashCode());

        System.out.println(file1 == file3);

        System.out.println(file1 == someFile);

        User user  = new User(111);

        System.out.println(file1.equals(user));



    }
}
