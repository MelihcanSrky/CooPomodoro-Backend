package com.sarikaya.CooPomodoro.modules.team.responses;

import com.sarikaya.CooPomodoro.modules.task.responses.GetTaskResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeamMemberUserResponse {
    private String userUuid;
    private String username;
    private String firstname;
    private String lastname;
    private Long createdAt;
}
