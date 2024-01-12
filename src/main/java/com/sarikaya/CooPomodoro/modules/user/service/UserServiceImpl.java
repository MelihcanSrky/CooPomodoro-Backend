package com.sarikaya.CooPomodoro.modules.user.service;

import com.sarikaya.CooPomodoro.core.utils.mappers.IModelMapperService;
import com.sarikaya.CooPomodoro.entities.User;
import com.sarikaya.CooPomodoro.modules.user.repository.UserRepository;
import com.sarikaya.CooPomodoro.modules.user.requests.CreateUserRequest;
import com.sarikaya.CooPomodoro.modules.user.responses.GetUserResponse;
import com.sarikaya.CooPomodoro.modules.user.rules.UserBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private IModelMapperService modelMapperService;
    private UserBusinessRules userBusinessRules;

    @Override
    public void add(CreateUserRequest createUserRequest) {
        this.userBusinessRules.checkIfUsernameExists(createUserRequest.getUsername());
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public GetUserResponse getUserByUuid(String uuid) {
        User user = this.userRepository.getUserByAuthId(uuid);
        return this.modelMapperService.forResponse().map(user, GetUserResponse.class);
    }
}
