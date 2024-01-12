package com.sarikaya.CooPomodoro.modules.task.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskRequest {
    @NonNull
    private String taskUuid;
    private String progress;
}
