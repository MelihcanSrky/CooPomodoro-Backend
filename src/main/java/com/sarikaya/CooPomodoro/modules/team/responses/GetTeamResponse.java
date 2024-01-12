package com.sarikaya.CooPomodoro.modules.team.responses;

import com.sarikaya.CooPomodoro.entities.Chat;
import com.sarikaya.CooPomodoro.entities.Member;
import com.sarikaya.CooPomodoro.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeamResponse {
    private String teamUuid;
    private String teamname;
    private int createdAt;
    private List<GetTeamMemberResponse> users;
    private List<GetTeamChatResponse> chats;
    private List<GetTeamPomodoroResponse> pomodoros;
}
