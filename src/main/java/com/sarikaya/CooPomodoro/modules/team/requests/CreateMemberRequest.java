package com.sarikaya.CooPomodoro.modules.team.requests;

import com.sarikaya.CooPomodoro.entities.Team;
import com.sarikaya.CooPomodoro.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMemberRequest {
    private int role = 1; //1-member, 2-founder
    private CreateMemberUserRequest user;
    private CreateMemberTeamRequest team;
}
