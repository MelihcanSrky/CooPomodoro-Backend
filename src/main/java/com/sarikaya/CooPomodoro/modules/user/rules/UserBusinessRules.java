package com.sarikaya.CooPomodoro.modules.user.rules;

import com.sarikaya.CooPomodoro.core.utils.exceptions.BusinessException;
import com.sarikaya.CooPomodoro.modules.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private UserRepository userRepository;

    public void  checkIfUsernameExists(String username) {
        if (this.userRepository.existsByUsername(username)) {
            throw new BusinessException("Username already exists");
        }
    }
}
