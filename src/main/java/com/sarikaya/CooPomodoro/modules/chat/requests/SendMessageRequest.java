package com.sarikaya.CooPomodoro.modules.chat.requests;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendMessageRequest {
    private String content;
    private Long createdAt;
    private String userUuid;
    private String chatUuid;
}
