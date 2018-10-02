package lessons.lesson10.polyExample;

public class User extends Human {

    public User(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("User class called");
        super.run();
    }
}
