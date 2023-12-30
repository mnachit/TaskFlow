package org.example.taskflow.web.rest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.taskflow.domain.dto.TaskDto;
import org.example.taskflow.domain.entities.Task;
import org.example.taskflow.domain.mapper.TaskMapper;
import org.example.taskflow.handler.exception.ValidationException;
import org.example.taskflow.service.TaskService;
import org.example.taskflow.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/task")
@RestController
@AllArgsConstructor
public class TaskConroller {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Response<TaskDto>> createTask(@Valid @RequestBody TaskDto taskDto) {
        Response<TaskDto> taskDtoResponse = new Response<>();
        Task task = TaskMapper.RequestToTask(taskDto);
        try {
            taskDtoResponse.setResult(TaskMapper.TaskToResponse(taskService.CreateTask(task)));
            return ResponseEntity.ok(taskDtoResponse);
        } catch (ValidationException e) {
            taskDtoResponse.setErrors(e.getErrorMessages());
            return ResponseEntity.badRequest().body(taskDtoResponse);
        }
    }
}
