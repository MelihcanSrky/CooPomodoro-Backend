package com.sarikaya.CooPomodoro.modules.task.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTaskResponse {
    private String taskUuid;
    private String taskname;
    private String description;
    private String priority;
    private int deadline;
    private String progress;
    private int createdAt;
    private String userUuid;
}
