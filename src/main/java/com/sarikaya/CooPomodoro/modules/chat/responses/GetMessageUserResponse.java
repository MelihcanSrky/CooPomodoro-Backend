package com.sarikaya.CooPomodoro.modules.chat.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMessageUserResponse {
    private String userUuid;
    private String username;
    private String firstname;
    private String lastname;
}
