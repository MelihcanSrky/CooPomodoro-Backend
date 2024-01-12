package com.sarikaya.CooPomodoro.modules.chat.service;

import com.sarikaya.CooPomodoro.core.utils.mappers.IModelMapperService;
import com.sarikaya.CooPomodoro.entities.Chat;
import com.sarikaya.CooPomodoro.modules.chat.repository.ChatRepository;
import com.sarikaya.CooPomodoro.modules.chat.requests.CreateChatRequest;
import com.sarikaya.CooPomodoro.modules.chat.responses.GetChatResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
    private ChatRepository chatRepository;
    private IModelMapperService modelMapperService;

    @Override
    public void add(CreateChatRequest createChatRequest) {
        Chat chat = this.modelMapperService.forRequest().map(createChatRequest, Chat.class);
        this.chatRepository.save(chat);
    }

    @Override
    public GetChatResponse getChat(String chatUuid) {
        Chat chat = this.chatRepository.findChatByChatUuid(chatUuid);
        return this.modelMapperService.forResponse().map(chat, GetChatResponse.class);
    }
}
