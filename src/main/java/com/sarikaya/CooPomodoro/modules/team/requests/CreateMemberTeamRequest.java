package com.sarikaya.CooPomodoro.modules.team.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMemberTeamRequest {
    private String teamUuid;
    private String teamname;
}
