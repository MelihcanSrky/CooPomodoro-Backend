package com.sarikaya.CooPomodoro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_uuid")
    private String taskUuid;

    @Column(name = "taskname")
    private String taskname;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private String priority; // high memium low

    @Column(name = "progress")
    private String progress; // to do / in progress / completed / expired

    @Column(name = "deadline")
    private int deadline;

    @Column(name = "createdAt")
    private int createdAt;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
}
