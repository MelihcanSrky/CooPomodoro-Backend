package com.sarikaya.CooPomodoro.modules.task.service;

import com.sarikaya.CooPomodoro.modules.task.requests.CreateTaskRequest;
import com.sarikaya.CooPomodoro.modules.task.requests.UpdateTaskRequest;
import com.sarikaya.CooPomodoro.modules.task.responses.GetTaskResponse;

import java.util.List;

public interface TaskService {
    void add(CreateTaskRequest createTaskRequest);
    List<GetTaskResponse> getTasks(String userUuid);
    void update(UpdateTaskRequest updateTaskRequest);
    void delete(String taskUuid);
}
