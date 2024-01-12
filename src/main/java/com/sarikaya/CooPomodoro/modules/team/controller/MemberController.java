package com.sarikaya.CooPomodoro.modules.team.controller;

import com.sarikaya.CooPomodoro.core.utils.ApiResponse;
import com.sarikaya.CooPomodoro.core.utils.jwt.TokenValidation;
import com.sarikaya.CooPomodoro.modules.team.requests.CreateMemberRequest;
import com.sarikaya.CooPomodoro.modules.team.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/team/member")
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @TokenValidation
    @PostMapping()
    public ResponseEntity<ApiResponse> addMember(@RequestBody CreateMemberRequest createMemberRequest) {
        try {
            this.memberService.add(createMemberRequest);
            return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Success", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Error occurred while add member" + e.getMessage()));
        }
    }
}
