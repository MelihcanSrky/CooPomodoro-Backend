package com.sarikaya.CooPomodoro.modules.team.responses;

import com.sarikaya.CooPomodoro.modules.user.responses.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeamMemberResponse {
    private Long id;
    private int role;
    private GetTeamMemberUserResponse user;
}
