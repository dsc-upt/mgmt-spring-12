package Classes;
//package com.gdsc.users;

//import com.gdsc.common.Entity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class User extends Entity {
    public String firstName;
    public String lastName;
    public String email;
    public String role = "Default";

    public static void copyUser(User sourceUser, User destinationUser) {
        destinationUser.firstName = sourceUser.firstName;
        destinationUser.lastName = sourceUser.lastName;
        destinationUser.email = sourceUser.email;
        destinationUser.updated = sourceUser.updated;
    }
    public boolean isEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }

    public static User findById(List<User> users, String id) {
        return users.stream().filter(u -> u.id.equals(id)).findFirst().orElse(null);
    }
}
