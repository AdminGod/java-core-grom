package finalProject.controller;

import finalProject.model.User;
import finalProject.service.UserService;

public class UserController {

    private UserService userService = new UserService();

    public User registerUser (User user){
        return userService.registerUser(user);
    }

    public User loginUser (String login, String password) {
        return userService.loginUser(login, password);
    }

}
