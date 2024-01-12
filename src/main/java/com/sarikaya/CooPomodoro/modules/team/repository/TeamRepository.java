package com.sarikaya.CooPomodoro.modules.team.repository;

import com.sarikaya.CooPomodoro.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
    Team getTeamByTeamUuid(String teamUuid);
}
