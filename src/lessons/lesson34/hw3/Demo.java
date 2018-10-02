package lessons.lesson34.hw3;

public class Demo {
    public static void main(String[] args) throws Exception{
        String pathFrom = new String("E:\\MEGA\\PT\\java-core-grom_fixed\\test3.txt");
        String pathTo = new String("E:\\MEGA\\PT\\java-core-grom_fixed\\test1.txt");

        Solution.copyFileContent(pathFrom, pathTo);
        //Solution.copyFileCOntentByApacheIO(pathFrom, pathTo);
    }
}


