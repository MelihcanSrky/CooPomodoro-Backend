package com.sarikaya.CooPomodoro.modules.user.controller;

import com.sarikaya.CooPomodoro.core.utils.ApiResponse;
import com.sarikaya.CooPomodoro.core.utils.jwt.JwtTokenUtil;
import com.sarikaya.CooPomodoro.core.utils.jwt.TokenValidation;
import com.sarikaya.CooPomodoro.modules.user.requests.CreateUserRequest;
import com.sarikaya.CooPomodoro.modules.user.responses.GetLoginUserResponse;
import com.sarikaya.CooPomodoro.modules.user.responses.GetUserResponse;
import com.sarikaya.CooPomodoro.modules.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateUserRequest createUserRequest) {
        this.userService.add(createUserRequest);
    }

    @PostMapping("/login/{authId}")
    public ResponseEntity<ApiResponse<String>> login(@PathVariable String authId) {
        GetUserResponse response = userService.getUserByUuid(authId);
        String token = jwtTokenUtil.generateToken(response.getUserUuid());

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), token, null));
    }

    @TokenValidation
    @GetMapping("/{uuid}")
    public ResponseEntity<ApiResponse<GetUserResponse>> getUserByUuid(@PathVariable String uuid) {
        GetUserResponse userResponse = userService.getUserByUuid(uuid);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), userResponse, null));
    }
}
