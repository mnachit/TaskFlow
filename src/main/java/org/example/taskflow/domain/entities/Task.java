package org.example.taskflow.domain.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.taskflow.domain.enums.StatusTask;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Enabled
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "task_tags", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Tag> tags;
    @Enumerated(EnumType.STRING)
    private StatusTask status;
}
