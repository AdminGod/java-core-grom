package finalProject.service;

import finalProject.dao.UserDao;
import finalProject.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public User registerUser (User user){
        //check buisness logic (fields can't be null, user must be older 18 y.o.)
        return userDao.registerUser(user);
    }
}
