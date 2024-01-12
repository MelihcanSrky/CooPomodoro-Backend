package com.sarikaya.CooPomodoro.modules.team.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeamRequest {
    private String teamname;
    private String founder;
    private int createdAt;
}
