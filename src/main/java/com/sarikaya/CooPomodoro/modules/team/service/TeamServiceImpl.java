package com.sarikaya.CooPomodoro.modules.team.service;

import com.sarikaya.CooPomodoro.core.utils.mappers.IModelMapperService;
import com.sarikaya.CooPomodoro.entities.Team;
import com.sarikaya.CooPomodoro.modules.team.repository.TeamRepository;
import com.sarikaya.CooPomodoro.modules.team.requests.CreateTeamRequest;
import com.sarikaya.CooPomodoro.modules.team.responses.GetTeamResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService{
    private TeamRepository teamRepository;
    private IModelMapperService modelMapperService;

    @Override
    public void add(CreateTeamRequest createTeamRequest) {
        Team team = this.modelMapperService.forRequest().map(createTeamRequest, Team.class);
        this.teamRepository.save(team);
    }

    @Override
    public GetTeamResponse getTeam(String teamUuid) {
        Team team = this.teamRepository.getTeamByTeamUuid(teamUuid);
        return this.modelMapperService.forResponse().map(team, GetTeamResponse.class);
    }
}
