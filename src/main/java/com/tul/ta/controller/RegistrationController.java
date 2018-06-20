package com.tul.ta.controller;

import com.tul.ta.model.user.User;
import com.tul.ta.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = GET)
    public ResponseEntity getAllUsers() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/user/{id}", method = GET)
    public ResponseEntity getUserById(@PathVariable(value = "id") String username) {
        return ResponseEntity.ok(userService.getUserById(username));
    }

    @RequestMapping(value = "/user/register", method = POST)
    public ResponseEntity registerUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.status(200).build();
    }
}
