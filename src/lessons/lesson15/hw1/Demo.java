package lessons.lesson15.hw1;

public class Demo {
    public static void main(String[] args) {
        User u1 = new User(1, "Name1", "Session1");
        User u2 = new User(2, "Name2", "Session2");
        User u3 = null;
        User u4 = new User(4, "Name4", "Session4");

        User[] us1 = null;
        User[] us2 = {u1, u2, u3};

        UserRepository userRepository = new UserRepository(us2);

        userRepository.save(u4);
        String n = null;
    }
}
