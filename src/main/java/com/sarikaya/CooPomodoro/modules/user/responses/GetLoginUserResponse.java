package com.sarikaya.CooPomodoro.modules.user.responses;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLoginUserResponse {
    @Nullable
    private String token;
    @Nullable
    private GetUserResponse user;
}
