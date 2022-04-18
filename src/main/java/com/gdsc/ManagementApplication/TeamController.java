package com.gdsc.ManagementApplication;

import Classes.Team;
import Classes.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class TeamController {
    static final List<Team> teams = new ArrayList<Team>();

    @PostMapping("/teams")
    public Team AddTeam(@RequestBody Team team){
        teams.add(team);
        return team;
    }

    @GetMapping("/teams")
    public List<Team> GetTeams(){
        return teams;
    }

    @GetMapping("/teams/{id}")
    public Team GetTeamById(@RequestParam String id){
        Team team = Team.findById(teams, id);
        return team;
    }

    @DeleteMapping("/teams")
    public Team DeleteTeam(@RequestParam String id){
        Team team = Team.findById(teams, id);
        teams.remove(team);
        return team;
    }

    @PutMapping("/teams")
    public Team UpdateTeam(@RequestBody Team team, @RequestParam String id){
        Team destinationTeam = Team.findById(teams, id);
        Team.copyTeam(team, destinationTeam);
        return destinationTeam;
    }

    @PatchMapping("/teams")
    public User ChangeTeamLead(@RequestBody User newTeamLead, @RequestParam String id){
        Team team = Team.findById(teams, id);
        team.teamLead = newTeamLead;
        return team.teamLead;
    }
}
