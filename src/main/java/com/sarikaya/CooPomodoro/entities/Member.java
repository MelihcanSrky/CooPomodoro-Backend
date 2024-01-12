package com.sarikaya.CooPomodoro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Members")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private int role; //1-member, 2-founder

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_uuid")
    private Team team;
}
