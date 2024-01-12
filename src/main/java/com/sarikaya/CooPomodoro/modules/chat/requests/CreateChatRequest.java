package com.sarikaya.CooPomodoro.modules.chat.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateChatRequest {
    @NonNull
    private String chatname;
    private int createdAt;
    @NonNull
    private String teamUuid;
}
