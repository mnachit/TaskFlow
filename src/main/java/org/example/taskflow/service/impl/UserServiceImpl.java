package org.example.taskflow.service.impl;

import org.example.taskflow.domain.entities.User;
import org.example.taskflow.domain.enums.Role;
import org.example.taskflow.handler.exception.ValidationException;
import org.example.taskflow.repository.UserRepository;
import org.example.taskflow.service.UserService;
import org.example.taskflow.utils.ErrorMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private List<ErrorMessage> errorMessages = new ArrayList<>();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User CreateUser(User user) throws ValidationException {
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            errorMessages.add(ErrorMessage.builder().message("Email already exists").build());
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            errorMessages.add(ErrorMessage.builder().message("Username already exists").build());
        if (errorMessages.size() > 0)
            throw new ValidationException(errorMessages);
        user.setRole(Role.USER);
        return userRepository.save(user);
    }
}
