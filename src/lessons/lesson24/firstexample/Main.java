package lessons.lesson24.firstexample;

public class Main {

    private static void demo(){

        User user = new User(11);
        Solution solution = new Solution("test1");

        Demo<User> demo = new Demo<>();

        Demo<Solution> solution1 = new Demo<>();
        demo.print(user);
        solution1.print(solution);
    }

    public static void main(String[] args) {
        demo();
    }
}
