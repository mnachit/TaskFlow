package org.example.taskflow.service.impl;

import lombok.AllArgsConstructor;
import org.example.taskflow.domain.entities.Task;
import org.example.taskflow.domain.enums.Role;
import org.example.taskflow.domain.enums.StatusTask;
import org.example.taskflow.handler.exception.ValidationException;
import org.example.taskflow.repository.TaskRepository;
import org.example.taskflow.service.TaskService;
import org.example.taskflow.utils.ErrorMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private List<ErrorMessage> errorMessages = new ArrayList<>();


    @Override
    public Task CreateTask(Task task) throws ValidationException {
        if(task.getStartDate().isBefore(LocalDateTime.now()))
            errorMessages.add(ErrorMessage.builder().message("Task start date cannot be in the past.").build());
        if (task.getEndDate().isAfter(LocalDateTime.now().plusDays(3)))
            errorMessages.add(ErrorMessage.builder().message("Task end date should be at least 3 days from now.").build());
        if (task.getTags().size() < 2) {
            errorMessages.add(ErrorMessage.builder().message("A task should have at least 2 tags.").build());
        }

        if (Role.USER.equals(task.getCreatedBy().getRole()) && !task.getCreatedBy().equals(task.getAssignedTo()))
            errorMessages.add(ErrorMessage.builder().message("A user can assign tasks only to themselves and not to others.").build());
        if (errorMessages.size() > 0)
            throw new ValidationException(errorMessages);
        
        task.setStatus(StatusTask.TODO);
        return taskRepository.save(task);
    }
}
