package org.example.taskflow.service;

import org.example.taskflow.domain.entities.User;
import org.example.taskflow.handler.exception.ValidationException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User CreateUser(User user) throws ValidationException;
}
