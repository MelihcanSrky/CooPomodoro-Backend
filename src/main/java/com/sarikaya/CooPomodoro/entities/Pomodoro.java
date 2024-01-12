package com.sarikaya.CooPomodoro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Pomodoro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pomodoro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pomodoro_uuid")
    private String pomodoroUuid;

    @Column(name = "roomname")
    private String roomname;

    @Column(name = "pomodoro_session")
    private int pomodoroSession;

    @Column(name = "short_break_session")
    private int shortBreakSession;

    @Column(name = "long_break_session")
    private int longBreakSession;

    @Column(name = "pomodoros_until_long_break")
    private int pomodorosUntilLongBreak;

    @Column(name = "session_started_at")
    private int sessionStartedAt;

    @Column(name = "visibility")
    private int visibility; // 1- private, 2- public, 3- team

    @Column(name = "is_activated")
    private Boolean isActivated = false;

    @Column(name = "is_stopped")
    private Boolean isStopped = false;

    @Column(name = "current_session") // 1- Pomodoro, 2- short, 3- long, 4- idle
    private int currentSession = 4;

    @Column(name = "createdAt")
    private int createdAt;

    @ManyToOne
    @JoinColumn(name = "team_uuid")
    private Team team;
}
