package com.sarikaya.CooPomodoro.modules.chat.service;

import com.sarikaya.CooPomodoro.entities.Message;
import com.sarikaya.CooPomodoro.modules.chat.requests.SendMessageRequest;
import com.sarikaya.CooPomodoro.modules.chat.responses.GetMessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MessageService {
    GetMessageResponse sendMessage(SendMessageRequest messageRequest);
    Page<GetMessageResponse> getChatMessages(String chatUuid, int page, int limit);
}
