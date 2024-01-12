package com.sarikaya.CooPomodoro.modules.team.service;

import com.sarikaya.CooPomodoro.modules.team.requests.CreateTeamRequest;
import com.sarikaya.CooPomodoro.modules.team.responses.GetTeamResponse;

public interface TeamService {
    void add(CreateTeamRequest createTeamRequest);
    GetTeamResponse getTeam(String teamUuid);
}
