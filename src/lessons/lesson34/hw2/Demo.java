package lessons.lesson34.hw2;

public class Demo {
    public static void main(String[] args) throws Exception{
        String pathFrom = new String("E:\\MEGA\\PT\\java-core-grom_fixed\\test3.txt");
        String pathTo = new String("E:\\MEGA\\PT\\java-core-grom_fixed\\test1.txt");

        Solution.transferSentences(pathFrom, pathTo, "dvlExpress");
    }
}
