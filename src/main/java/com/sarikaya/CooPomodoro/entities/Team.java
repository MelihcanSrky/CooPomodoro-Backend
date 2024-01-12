package com.sarikaya.CooPomodoro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="Team")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "team_uuid")
    private String teamUuid;

    @Column(name = "teamname")
    private String teamname;

    @Column(name = "founder")
    private String founder;

    @Column(name = "createdAt")
    private int createdAt;

    @OneToMany(mappedBy = "team")
    private List<Member> users;

    @OneToMany(mappedBy = "team")
    private List<Chat> chats;

    @OneToMany(mappedBy = "team")
    private List<Pomodoro> pomodoros;
}
