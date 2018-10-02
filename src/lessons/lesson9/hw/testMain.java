package lessons.lesson9.hw;

public class testMain {
    public static void main(String[] args) {
        User u1 = new User(1233, "name1", "jaskdbfk");
        User u2 = new User(1233, "name2", "jaskdbfk");
        User [] users = new User [5];
        users[1] = u1;
        users[2] = u2;
        System.out.println(users[0]);

    }
}
