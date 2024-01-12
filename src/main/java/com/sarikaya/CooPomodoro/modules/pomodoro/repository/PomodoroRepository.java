package com.sarikaya.CooPomodoro.modules.pomodoro.repository;

import com.sarikaya.CooPomodoro.entities.Pomodoro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PomodoroRepository extends JpaRepository<Pomodoro, String> {
}
