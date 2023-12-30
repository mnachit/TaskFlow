package org.example.taskflow.domain.mapper;

import org.example.taskflow.domain.dto.TaskDto;
import org.example.taskflow.domain.entities.Tag;
import org.example.taskflow.domain.entities.Task;
import org.example.taskflow.domain.entities.User;

import java.util.ArrayList;
import java.util.List;

public class TaskMapper {
    public static Task RequestToTask(TaskDto taskDtoRequest) {
        List<Tag> tagsList = new ArrayList<>();
        for (String tagName : taskDtoRequest.getTags()) {
            tagsList.add(Tag.builder().name(tagName).build());
        }

        return Task.builder()
                .name(taskDtoRequest.getName())
                .description(taskDtoRequest.getDescription())
                .startDate(taskDtoRequest.getStartDate())
                .endDate(taskDtoRequest.getEndDate())
                .createdBy(User.builder().id(taskDtoRequest.getCreatedBy()).build())
                .assignedTo(User.builder().id(taskDtoRequest.getAssignedTo()).build())
                .tags(tagsList)
                .status(taskDtoRequest.getStatus()).build();
    }

    public static TaskDto TaskToResponse(Task task) {
        List<String> tagNames = new ArrayList<>();
        for (Tag tag : task.getTags()) {
            tagNames.add(tag.getName());
        }
        return TaskDto.builder()
                .name(task.getName())
                .description(task.getDescription())
                .startDate(task.getStartDate())
                .endDate(task.getEndDate())
                .createdBy(task.getCreatedBy().getId())
                .assignedTo(task.getAssignedTo().getId())
//                .tags(tagNames)
                .status(task.getStatus())
                .build();
    }
}
