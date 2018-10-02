package lessons.lesson9;

import lessons.lesson9.hw.User;
import lessons.lesson9.hw.UserRepository;
import lessons.lesson9.utils.Checker;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company();
        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());

        company.setName("IBM");

        Checker checker = new Checker();
        //Sys.out.println(checker.checkCompanyName(company.getName()));
        //Sys.out.println(checker.companyNamesValidatedCount);
        //company.code;

        //testing useRepository.getNames;

        User u1 = new User(1, "User1", "zzz");
        User u2 = new User(2, "User2", "aaa");
        User [] users = new User[2];
        User [] users1 = null;
        User [] users2 = new User[3];
        users2[2] = u1;
        users2[0] = u2;


        UserRepository userRepository = new UserRepository(users);
        UserRepository userRepository1 = new UserRepository(users1);
        UserRepository userRepository2 = new UserRepository(users2);

        System.out.println(Arrays.deepToString(userRepository.getUserNames()));//вызов с нулевых юзеровб return new String[0]
        System.out.println(Arrays.deepToString(userRepository1.getUserNames()));//вызов от нала, return new String[0]
        System.out.println(Arrays.deepToString(userRepository2.getUserNames()));//вызов от массива с налами и без, return array Strings

        //testing userRepoitory.getUserIds
        System.out.println(Arrays.deepToString(new long[][]{userRepository.getUserIds()}));//вызов с нулевых юзеровб return new long[0]
        System.out.println(Arrays.deepToString(new long[][]{userRepository1.getUserIds()}));//вызов от нала, return new long[0]
        System.out.println(Arrays.deepToString(new long[][]{userRepository2.getUserIds()}));//вызов от массива с налами и без, return array longs

        // testing userUepository.getUserNameById
        System.out.println(userRepository.getUserNameById(1));//get ID from array with nulls, not found, retun null
        System.out.println(userRepository1.getUserNameById(2));//get user name by id from null array, return null
        System.out.println(userRepository2.getUserNameById(2));//get User Name from arry with data and which equal with someones user

        //testing userRepository.getUserByName
        System.out.println("user name is: " + userRepository.getUserByName("user123213"));//get user name from array with nulls, not found, retun null
        System.out.println("user name is: " + userRepository1.getUserByName(null));//get user name from null name null array, return null
        System.out.println("user name is: " + userRepository2.getUserNameById(2));//get User Name from arry with data and which equal with someones user

        //testing userRepository.getUserBySessionId
        System.out.println("user name is: " + userRepository.getUserBySessionId("user123213"));//get user name from array with nulls, not found, retun null
        System.out.println("user name is: " + userRepository1.getUserBySessionId(null));//get user name from null name null array, return null
        System.out.println("user name is: " + userRepository2.getUserBySessionId(""));//get User Name from arry with data and which equal with someones user

        //testing userRepository.save()
        User us1 = new User(11, "us1", "session1");
        User us2 = new User(12, "us2", "session1");
        System.out.println("save1 " + userRepository.save(us1));//save normal
        System.out.println("save2-1 " + userRepository1.save(us1));//save in null array
        System.out.println("save2-2 " + userRepository1.save(us1));//save with the same id
        System.out.println("save2-3" + userRepository2.save(us1));//fill out all array
        System.out.println("save2-4" + userRepository2.save(us2));//save to full array
        System.out.println("******************************");

        //testing userRepository.update()
        System.out.println("update1 " + userRepository1.update(us1));//update in null users array
        User us3 = new User(11, "us3", "session_us3");
        System.out.println("update " + userRepository.update(us3));//update by id
        User us4 = null;
        System.out.println("update 4" + userRepository.update(us4));//update user == null

        //testing userRepository.delete()
        System.out.println("delete");
        System.out.println(Arrays.deepToString(new long[][]{userRepository.getUserIds()}));//show all before removing
        userRepository.delete(1);//remove not found
        System.out.println(Arrays.deepToString(new long[][]{userRepository.getUserIds()}));//show all after removing
        userRepository.delete(11);//remove
        System.out.println(Arrays.deepToString(new long[][]{userRepository.getUserIds()}));//show all after removing
        UserRepository userRepository3 = new UserRepository(null);
        userRepository3.delete(11);//remove from null users' array
        System.out.println(Arrays.deepToString(new long[][]{userRepository.getUserIds()}));//show all after removing


        String s1 = "";
    }
}
