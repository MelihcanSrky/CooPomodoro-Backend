package com.sarikaya.CooPomodoro.modules.pomodoro.controller;

import com.sarikaya.CooPomodoro.core.utils.jwt.TokenValidation;
import com.sarikaya.CooPomodoro.modules.pomodoro.requests.CreatePomodoroRequest;
import com.sarikaya.CooPomodoro.modules.pomodoro.service.PomodoroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pomodoro")
@AllArgsConstructor
public class PomodoroController {
    private PomodoroService pomodoroService;

    @TokenValidation
    @PostMapping("/create")
    public void add(@RequestBody CreatePomodoroRequest createPomodoroRequest) {
        this.pomodoroService.add(createPomodoroRequest);
    }
}
