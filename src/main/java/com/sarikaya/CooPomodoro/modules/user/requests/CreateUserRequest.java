package com.sarikaya.CooPomodoro.modules.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NonNull
    private String authId;
    @NonNull
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Long createdAt;
}
