package lesson36.service;

import lesson36.dao.UserDao;
import lesson36.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public User registerUser (User user){
        //check buisness logic (fields can't be null, user must be older 18 y.o.)
        return userDao.registerUser(user);
    }
}
