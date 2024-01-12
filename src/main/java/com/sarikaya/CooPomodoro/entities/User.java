package com.sarikaya.CooPomodoro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="user_uuid")
    private String userUuid;

    @Column(name="auth_id")
    private String authId;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    private Long createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "user")
    private List<Member> memberships;

    @OneToMany(mappedBy = "user")
    private List<Message> messages;
}
