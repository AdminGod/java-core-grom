package lesson36.controller;

import lesson36.model.User;
import lesson36.service.UserService;

public class UserController {

    private UserService userService = new UserService();

    public User registerUser (User user){
        return userService.registerUser(user);
    }
}
