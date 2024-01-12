package com.sarikaya.CooPomodoro.modules.team.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeamPomodoroResponse {
    private String pomodoroUuid;
    private String roomname;
    private int currentSession;
}
