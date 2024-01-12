package com.sarikaya.CooPomodoro.modules.chat.websocket;

import com.sarikaya.CooPomodoro.modules.chat.requests.SendMessageRequest;
import com.sarikaya.CooPomodoro.modules.chat.responses.GetMessageResponse;
import com.sarikaya.CooPomodoro.modules.chat.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MessageWebSocketController {
    private MessageService messageService;

    @MessageMapping("/chat/{chatUuid}")
    @SendTo("/topic/chat/{chatUuid}")
    public GetMessageResponse sendMessage(@DestinationVariable String chatUuid, @Payload SendMessageRequest  sendMessageRequest) throws Exception {
        return this.messageService.sendMessage(sendMessageRequest);
   }
}
