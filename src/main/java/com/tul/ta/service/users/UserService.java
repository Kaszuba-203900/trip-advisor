package com.tul.ta.service.users;

import com.tul.ta.model.user.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getUserById(String username);

    void save(User user);
}
