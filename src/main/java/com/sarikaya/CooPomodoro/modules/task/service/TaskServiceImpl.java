package com.sarikaya.CooPomodoro.modules.task.service;

import com.sarikaya.CooPomodoro.core.utils.mappers.IModelMapperService;
import com.sarikaya.CooPomodoro.entities.Task;
import com.sarikaya.CooPomodoro.modules.task.repository.TaskRepository;
import com.sarikaya.CooPomodoro.modules.task.requests.CreateTaskRequest;
import com.sarikaya.CooPomodoro.modules.task.requests.UpdateTaskRequest;
import com.sarikaya.CooPomodoro.modules.task.responses.GetTaskResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private IModelMapperService modelMapperService;

    @Override
    public void add(CreateTaskRequest createTaskRequest) {
        Task task = this.modelMapperService.forRequest().map(createTaskRequest, Task.class);
        this.taskRepository.save(task);
    }

    @Override
    public List<GetTaskResponse> getTasks(String userUuid) {
        List<Task> tasks = this.taskRepository.findByUser_UserUuid(userUuid);
        List<GetTaskResponse> response = tasks.stream()
                .map(task -> this.modelMapperService.forResponse().map(task, GetTaskResponse.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public void update(UpdateTaskRequest updateTaskRequest) {
        Task task = this.taskRepository.findByTaskUuid(updateTaskRequest.getTaskUuid());
        if (task != null) {
            if (updateTaskRequest.getProgress() != null) {
                task.setProgress(updateTaskRequest.getProgress());
            }
            this.taskRepository.save(task);
        }
    }

    @Override
    public void delete(String taskUuid) {
        this.taskRepository.deleteById(taskUuid);
    }
}
