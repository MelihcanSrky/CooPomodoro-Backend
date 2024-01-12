package com.sarikaya.CooPomodoro.modules.user.responses;

import com.sarikaya.CooPomodoro.entities.Task;
import com.sarikaya.CooPomodoro.modules.task.responses.GetTaskResponse;
import com.sarikaya.CooPomodoro.modules.team.responses.GetMemberResponse;
import com.sarikaya.CooPomodoro.modules.team.responses.GetTeamResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
    private String userUuid;
    private String authId;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Long createdAt;
    private List<GetTaskResponse> tasks;
    private List<GetMemberResponse> memberships;
}
