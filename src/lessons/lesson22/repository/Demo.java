package lessons.lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User u1 = new User(1001, "Daniil", "3sd1f32das13");
        UserRepository.save(u1);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User u2 = new User(1002, "Andrey", "3sdszXCZXV13");
        UserRepository.save(u2);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User u3 = new User(1001, "Test", "3sd1f32das13");
        UserRepository.update(u3);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        UserRepository.delete(1001);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        System.out.println(UserRepository.getUserByName("Andrey").toString());

        System.out.println(UserRepository.getUserNameById(1002));
    }
}
