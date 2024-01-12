package com.sarikaya.CooPomodoro.modules.user.service;

import com.sarikaya.CooPomodoro.modules.user.requests.CreateUserRequest;
import com.sarikaya.CooPomodoro.modules.user.responses.GetUserResponse;

public interface UserService {
    void add(CreateUserRequest createUserRequest);
    GetUserResponse getUserByUuid(String uuid);
}
