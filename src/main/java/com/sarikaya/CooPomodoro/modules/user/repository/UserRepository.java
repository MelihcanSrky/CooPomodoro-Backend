package com.sarikaya.CooPomodoro.modules.user.repository;

import com.sarikaya.CooPomodoro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
    User getUserByAuthId(String authId);
}
