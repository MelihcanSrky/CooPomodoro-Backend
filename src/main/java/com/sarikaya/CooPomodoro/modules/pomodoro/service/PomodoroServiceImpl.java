package com.sarikaya.CooPomodoro.modules.pomodoro.service;

import com.sarikaya.CooPomodoro.core.utils.mappers.IModelMapperService;
import com.sarikaya.CooPomodoro.entities.Pomodoro;
import com.sarikaya.CooPomodoro.modules.pomodoro.repository.PomodoroRepository;
import com.sarikaya.CooPomodoro.modules.pomodoro.requests.CreatePomodoroRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PomodoroServiceImpl implements PomodoroService {
    private PomodoroRepository pomodoroRepository;
    private IModelMapperService modelMapperService;
    @Override
    public void add(CreatePomodoroRequest createPomodoroRequest) {
        Pomodoro pomodoro = this.modelMapperService.forRequest().map(createPomodoroRequest, Pomodoro.class);
        this.pomodoroRepository.save(pomodoro);
    }
}
