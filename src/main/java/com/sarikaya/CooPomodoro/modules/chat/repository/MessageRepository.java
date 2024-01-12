package com.sarikaya.CooPomodoro.modules.chat.repository;

import com.sarikaya.CooPomodoro.entities.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, String>{
    Message findMessageByMessageUuid(String messageUuid);
    Page<Message> findMessagesByChat_ChatUuidOrderByCreatedAtDesc(String chatUuid, Pageable pageable);
}
