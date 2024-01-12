package com.sarikaya.CooPomodoro.modules.task.controller;

import com.sarikaya.CooPomodoro.core.utils.ApiResponse;
import com.sarikaya.CooPomodoro.core.utils.jwt.TokenValidation;
import com.sarikaya.CooPomodoro.modules.task.requests.CreateTaskRequest;
import com.sarikaya.CooPomodoro.modules.task.requests.UpdateTaskRequest;
import com.sarikaya.CooPomodoro.modules.task.responses.GetTaskResponse;
import com.sarikaya.CooPomodoro.modules.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    @TokenValidation
    @PostMapping("/{userUuid}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<ApiResponse> add(@RequestBody CreateTaskRequest createTaskRequest, @PathVariable String userUuid) {
        try {
            this.taskService.add(createTaskRequest);
            return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Success", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Error occurred while add task"));
        }
    }

    @TokenValidation
    @GetMapping("/{userUuid}")
    public ResponseEntity<ApiResponse> getUserTasks(@PathVariable String userUuid) {
        List<GetTaskResponse> tasks = this.taskService.getTasks(userUuid);
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), tasks, null));
    }

    @TokenValidation
    @PutMapping("/{userUuid}")
    public ResponseEntity<ApiResponse> updateUserTasks(@RequestBody UpdateTaskRequest updateTaskRequest) {
        try {
            this.taskService.update(updateTaskRequest);
            return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Data update success", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Error occurred while update task"));
        }
    }

    @TokenValidation
    @DeleteMapping("/{taskUuid}")
    public ResponseEntity<ApiResponse> deleteUserTasks(@PathVariable String taskUuid) {
        try {
            this.taskService.delete(taskUuid);
            return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Data Delete success", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Error occurred while delete task"));
        }
    }
}
