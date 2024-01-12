package com.sarikaya.CooPomodoro.modules.chat.service;

import com.sarikaya.CooPomodoro.core.utils.mappers.IModelMapperService;
import com.sarikaya.CooPomodoro.entities.Message;
import com.sarikaya.CooPomodoro.modules.chat.repository.MessageRepository;
import com.sarikaya.CooPomodoro.modules.chat.requests.SendMessageRequest;
import com.sarikaya.CooPomodoro.modules.chat.responses.GetMessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;
    private IModelMapperService modelMapperService;

    @Override
    public GetMessageResponse sendMessage(SendMessageRequest messageRequest) {
        Message message = this.modelMapperService.forRequest().map(messageRequest, Message.class);
        Message request = this.messageRepository.save(message);
        Message response = this.messageRepository.findMessageByMessageUuid(request.getMessageUuid());
        return this.modelMapperService.forResponse().map(response, GetMessageResponse.class);
    }

    @Override
    public Page<GetMessageResponse> getChatMessages(String chatUuid, int page, int limit) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        Page<Message> messages = this.messageRepository.findMessagesByChat_ChatUuidOrderByCreatedAtDesc(chatUuid, pageRequest);
//        List<GetMessageResponse> response = messages.getContent().stream()
//                .map(message -> this.modelMapperService.forResponse().map(message, GetMessageResponse.class))
//                .collect(Collectors.toList());
        return messages.map(message -> this.modelMapperService.forResponse().map(message, GetMessageResponse.class));

    }
}
