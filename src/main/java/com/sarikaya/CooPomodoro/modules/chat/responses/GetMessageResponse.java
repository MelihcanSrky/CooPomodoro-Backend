package com.sarikaya.CooPomodoro.modules.chat.responses;

import com.sarikaya.CooPomodoro.entities.Chat;
import com.sarikaya.CooPomodoro.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMessageResponse {
    private String messageUuid;
    private String content;
    private Long createdAt;
    private GetMessageUserResponse user;
}
