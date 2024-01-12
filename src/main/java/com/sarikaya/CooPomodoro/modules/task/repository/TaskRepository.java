package com.sarikaya.CooPomodoro.modules.task.repository;

import com.sarikaya.CooPomodoro.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findByUser_UserUuid(String userUuid);
    Task findByTaskUuid(String taskUuid);
}
