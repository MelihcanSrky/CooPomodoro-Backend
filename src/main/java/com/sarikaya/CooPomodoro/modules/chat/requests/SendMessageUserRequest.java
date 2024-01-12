package com.sarikaya.CooPomodoro.modules.chat.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageUserRequest {
    private String userUuid;
    private String username;
    private String firstname;
    private String lastname;
}
