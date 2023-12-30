package org.example.taskflow.service;

import org.example.taskflow.domain.entities.Task;
import org.example.taskflow.handler.exception.ValidationException;

public interface TaskService {
    public Task CreateTask(Task task) throws ValidationException;
}
