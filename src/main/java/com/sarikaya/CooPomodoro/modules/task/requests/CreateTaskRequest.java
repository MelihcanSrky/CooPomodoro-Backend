package com.sarikaya.CooPomodoro.modules.task.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskRequest {
    @NonNull
    private String taskname;
    private String description;
    private String priority;
    private int deadline;
    private int createdAt;
    private String progress;
    @NonNull
    private String userUuid;
}
