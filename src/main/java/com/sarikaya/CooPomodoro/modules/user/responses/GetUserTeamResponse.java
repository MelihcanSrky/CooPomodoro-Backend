package com.sarikaya.CooPomodoro.modules.user.responses;

import com.sarikaya.CooPomodoro.modules.team.responses.GetTeamMemberResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserTeamResponse {
    private String teamUuid;
    private String teamname;
    private int createdAt;
}
