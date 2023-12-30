package org.example.taskflow.domain.dto;

import jakarta.validation.constraints.*;
import jdk.jfr.Enabled;
import lombok.*;
import org.example.taskflow.domain.enums.StatusTask;


import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@Enabled
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @NotNull(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Start date is mandatory")
    @FutureOrPresent(message = "Start date must be in the future or present")
    private LocalDateTime startDate;

    @NotNull(message = "End date is mandatory")
    @Future(message = "End date must be in the future")
    private LocalDateTime endDate;

    @NotNull(message = "Created by is mandatory")
    private Long createdBy;

    @NotNull(message = "Assigned to is mandatory")
    private Long assignedTo;

    @NotNull(message = "Tags is mandatory")
    @NotEmpty(message = "Tags cannot be empty")
    private List<String> tags;

    private StatusTask status;
}

