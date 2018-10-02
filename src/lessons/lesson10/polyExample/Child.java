package lessons.lesson10.polyExample;

public class Child extends Human {

    public Child(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("User class called");
        super.run();
    }
}
