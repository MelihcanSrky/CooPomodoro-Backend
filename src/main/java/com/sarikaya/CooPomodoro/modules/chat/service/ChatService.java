package com.sarikaya.CooPomodoro.modules.chat.service;

import com.sarikaya.CooPomodoro.modules.chat.requests.CreateChatRequest;
import com.sarikaya.CooPomodoro.modules.chat.responses.GetChatResponse;

public interface ChatService {
    void add(CreateChatRequest createChatRequest);
    GetChatResponse getChat(String chatUuid);
}
