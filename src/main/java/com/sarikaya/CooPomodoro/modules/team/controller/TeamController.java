package com.sarikaya.CooPomodoro.modules.team.controller;

import com.sarikaya.CooPomodoro.core.utils.ApiResponse;
import com.sarikaya.CooPomodoro.core.utils.jwt.TokenValidation;
import com.sarikaya.CooPomodoro.modules.team.requests.CreateTeamRequest;
import com.sarikaya.CooPomodoro.modules.team.responses.GetTeamResponse;
import com.sarikaya.CooPomodoro.modules.team.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team")
@AllArgsConstructor
public class TeamController {
    private TeamService teamService;

    @PostMapping()
    @TokenValidation
    public ResponseEntity<ApiResponse> addTeam(@RequestBody CreateTeamRequest createTeamRequest) {
        try {
            this.teamService.add(createTeamRequest);
            return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Success", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Error occurred while add team" + e.getMessage()));
        }
    }

    @GetMapping("/{teamUuid}")
    @TokenValidation
    public ResponseEntity<ApiResponse> getTeam(@PathVariable String teamUuid) {
        try {
            GetTeamResponse getTeamResponse = this.teamService.getTeam(teamUuid);
            return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), getTeamResponse, null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Error occurred while add team" + e.getMessage()));
        }
    }
}
