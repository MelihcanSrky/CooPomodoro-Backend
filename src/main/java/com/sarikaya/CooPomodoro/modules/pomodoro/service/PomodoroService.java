package com.sarikaya.CooPomodoro.modules.pomodoro.service;

import com.sarikaya.CooPomodoro.modules.pomodoro.requests.CreatePomodoroRequest;

public interface PomodoroService {
    void add(CreatePomodoroRequest createPomodoroRequest);
}
