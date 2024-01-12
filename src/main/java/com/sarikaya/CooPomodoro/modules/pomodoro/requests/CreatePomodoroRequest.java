package com.sarikaya.CooPomodoro.modules.pomodoro.requests;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePomodoroRequest {
    @NonNull
    private String roomname;
    private int pomodoroSession;
    private int shortBreakSession;
    private int longBreakSession;
    private int pomodorosUntilLongBreak;
    private int visibility;
    private int createdAt;
    @Nullable
    private String teamUuid;
}
