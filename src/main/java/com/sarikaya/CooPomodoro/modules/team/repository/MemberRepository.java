package com.sarikaya.CooPomodoro.modules.team.repository;

import com.sarikaya.CooPomodoro.entities.Member;
import com.sarikaya.CooPomodoro.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
