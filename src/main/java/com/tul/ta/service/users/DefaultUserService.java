package com.tul.ta.service.users;

import com.tul.ta.exception.ResourceNotFoundException;
import com.tul.ta.model.user.User;
import com.tul.ta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String username) {
        return userRepository.findById(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", username));
    }

    @Override
    public void save(User user) {
        userRepository.saveAndFlush(user);
    }
}
