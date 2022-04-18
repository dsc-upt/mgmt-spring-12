package com.gdsc.ManagementApplication;

import Classes.Team;
import Classes.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {
    static final List<UserProfile> userProfiles = new ArrayList<UserProfile>();

    @PostMapping()
    public UserProfile Add(@RequestBody UserProfile userProfile, HttpServletResponse response) {
        if (userProfile.isPhone(userProfile.phone) == false) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        userProfiles.add(userProfile);
        return userProfile;
    }

    @GetMapping()
    public List<UserProfile> Get(){
        return userProfiles;
    }

    @GetMapping("/{id}")
    public UserProfile GetById(@RequestParam("id")String id){
        UserProfile userProfile = UserProfile.findById(userProfiles, id);
        return userProfile;
    }

    @DeleteMapping()
    public UserProfile Delete(@RequestParam("id")String id){
        UserProfile userProfile = UserProfile.findById(userProfiles, id);
        userProfiles.remove(userProfile);
        return userProfile;
    }

    @PutMapping()
    public UserProfile Update(@RequestBody UserProfile newUserProfile, @RequestParam("id")String id, HttpServletResponse response) {
        if (newUserProfile.isPhone(newUserProfile.phone) == false) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        UserProfile userProfile = UserProfile.findById(userProfiles, id);
        UserProfile.copyUserProfile(newUserProfile, userProfile);
        return userProfile;
    }

    @PatchMapping()
    public List<Team> ChangeTeam(@RequestBody List<Team> teams, @RequestParam("id") String id){
        UserProfile userProfile = UserProfile.findById(userProfiles, id);
        userProfile.teams = teams;
        return userProfile.teams;
    }
}
