package com.sarikaya.CooPomodoro.modules.chat.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetChatTeamResponse {
    private String teamUuid;
    private String teamname;
    private String founder;
}
