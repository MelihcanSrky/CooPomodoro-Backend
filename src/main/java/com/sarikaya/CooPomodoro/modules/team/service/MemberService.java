package com.sarikaya.CooPomodoro.modules.team.service;

import com.sarikaya.CooPomodoro.modules.team.requests.*;
import com.sarikaya.CooPomodoro.modules.team.responses.GetTeamResponse;

public interface MemberService {
    void add(CreateMemberRequest createMemberRequest);
}
