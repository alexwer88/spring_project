package ru.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.project.model.entity.User;
import ru.project.model.protocol.UserPhoneProtocol;
import ru.project.model.protocol.UserProtocol;

import ru.project.service.UserService;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by user on 30.09.16.
 */

@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public List<User> test() {
        return userService.getAllUsers();
    }

    @RequestMapping("/user/all")
    public List<UserPhoneProtocol> getUserPhones() {
        return userService.getUserPhoneProtocols();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/add")
    @ResponseBody
    public User add(@NotNull @RequestBody UserProtocol userProtocol) {
        return userService.addUser(userProtocol);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/delete/{userId}")
    @ResponseBody
    public void delete(@NotNull @PathVariable Integer userId) {
        userService.deleteUser(userId);
    }


}
