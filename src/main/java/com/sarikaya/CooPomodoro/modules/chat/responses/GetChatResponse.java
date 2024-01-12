package com.sarikaya.CooPomodoro.modules.chat.responses;

import com.sarikaya.CooPomodoro.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetChatResponse {
    private String chatUuid;
    private String chatname;
    private int createdAt;
    private GetChatTeamResponse team;
}
