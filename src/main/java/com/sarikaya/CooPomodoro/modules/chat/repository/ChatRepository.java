package com.sarikaya.CooPomodoro.modules.chat.repository;

import com.sarikaya.CooPomodoro.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, String> {
    Chat findChatByChatUuid(String chatUuid);
}
