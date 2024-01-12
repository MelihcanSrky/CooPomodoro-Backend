package com.sarikaya.CooPomodoro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "message_uuid")
    private String messageUuid;

    @Column(name = "content")
    private String content;

    @Column(name = "createdAt")
    private Long createdAt;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chat_uuid")
    private Chat chat;
}
