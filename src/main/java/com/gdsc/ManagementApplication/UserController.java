package com.gdsc.ManagementApplication;


import Classes.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    static final List<User> users = new ArrayList<User>();

    @PostMapping("/users")
    public User Add(@RequestBody User user,  HttpServletResponse response) {
        if (user.isEmail(user.email) == false) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        users.add(user);
        return user;
    }

    @DeleteMapping("/users")
    public User Delete(@RequestParam(value = "Delete an User") String id) {
        User user = users.stream().filter(u -> u.id.equals(id)).findFirst().orElse(null);
        users.remove(user);
        return user;
    }

    @PutMapping("/users")
    public User Update(@RequestBody User user, @RequestParam("id") String id,  HttpServletResponse response) {
        if (user.isEmail(user.email) == false) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        User updatedUser = User.findById(users, id);
        User.copyUser(user, updatedUser);
        return updatedUser;
    }

    @GetMapping("/users/{id}")
    public User Get(@RequestParam(value = "Post an User ID") String id) {
        return User.findById(users, id);
    }

    @GetMapping("/users")
    public List<User> Get() {
        return users;
    }

    @PatchMapping("/users")
    public String updateRole(@RequestParam("id") String id, @RequestParam("role") String role) {
        User user = User.findById(users, id);
        user.role = role;
        return user.role;
    }

    @PatchMapping("/users/{id}")
    public String deleteRole(@RequestParam("id") String id) {
        User user = User.findById(users, id);
        user.role = "Default";
        return user.role;
    }
}
