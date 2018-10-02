package lessons.lesson7;

import lessons.lesson6.User;

public class TestUser {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User("Name");

        u1.age = 321;
        u1.city = "Kh";
        System.out.println(u1.age + u1.city + u1.isActive + u1.lastActiveDate +u1.city);

    }
}
