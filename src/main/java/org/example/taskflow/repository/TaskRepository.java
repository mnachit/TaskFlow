package org.example.taskflow.repository;

import org.example.taskflow.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{
}
