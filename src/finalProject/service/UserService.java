package finalProject.service;

import finalProject.dao.UserDao;
import finalProject.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public User registerUser (User user){
        return userDao.registerUser(user);
    }

    public User loginUser (String login, String password){
        return userDao.loginUser(login, password);
    }

    public User getUserById (long id){
        return userDao.getUserById(id);
    }
}
