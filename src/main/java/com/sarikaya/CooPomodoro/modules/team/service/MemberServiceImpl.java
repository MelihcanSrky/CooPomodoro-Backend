package com.sarikaya.CooPomodoro.modules.team.service;

import com.sarikaya.CooPomodoro.core.utils.mappers.IModelMapperService;
import com.sarikaya.CooPomodoro.entities.Member;
import com.sarikaya.CooPomodoro.entities.Team;
import com.sarikaya.CooPomodoro.entities.User;
import com.sarikaya.CooPomodoro.modules.team.repository.MemberRepository;
import com.sarikaya.CooPomodoro.modules.team.requests.*;
import com.sarikaya.CooPomodoro.modules.team.responses.GetTeamResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

    private MemberRepository memberRepository;
    private IModelMapperService modelMapperService;

    @Override
    public void add(CreateMemberRequest createMemberRequest) {
        Member member = this.modelMapperService.forRequest().map(createMemberRequest, Member.class);
        this.memberRepository.save(member);
    }
}
