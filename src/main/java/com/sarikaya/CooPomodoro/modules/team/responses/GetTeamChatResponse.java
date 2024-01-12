package com.sarikaya.CooPomodoro.modules.team.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeamChatResponse {
    private String chatUuid;
    private String chatname;
}
