package com.sarikaya.CooPomodoro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "Chats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "chat_uuid")
    private String chatUuid;

    @Column(name = "chatname")
    private String chatname;

    @Column(name = "createdAt")
    private int createdAt;

    @ManyToOne
    @JoinColumn(name = "team_uuid")
    private Team team;

    @OneToMany(mappedBy = "chat")
    private List<Message> messages;
}
