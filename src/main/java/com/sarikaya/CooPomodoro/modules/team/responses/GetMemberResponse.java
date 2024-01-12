package com.sarikaya.CooPomodoro.modules.team.responses;

import com.sarikaya.CooPomodoro.entities.Team;
import com.sarikaya.CooPomodoro.entities.User;
import com.sarikaya.CooPomodoro.modules.user.responses.GetUserTeamResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMemberResponse {
    private Long id;
    private int role;
    private GetUserTeamResponse team;
}
