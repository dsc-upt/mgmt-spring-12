package Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Date;
import java.awt.*;

public class UserProfile extends Entity{
    public User user;
    public List<Team> teams;
    public String facebookLink;
    public String phone;
    public Date birthday;
    //public Image picture;

    public static void copyUserProfile(UserProfile sourceUser, UserProfile destinationUser) {
        destinationUser.user = sourceUser.user;
        destinationUser.teams = sourceUser.teams;
        destinationUser.facebookLink = sourceUser.facebookLink;
        destinationUser.phone = sourceUser.phone;
        destinationUser.birthday = sourceUser.birthday;
        //destinationUser.picture = sourceUser.picture;
        destinationUser.updated = sourceUser.updated;
    }

    public boolean isPhone(String phone) {
        String regex = "^[07]{2}[0-9]{8}$";
        return Pattern.matches(regex, phone);
    }

    public static UserProfile findById(List<UserProfile> userProfiles, String id) {
        return userProfiles.stream().filter(u -> u.id.equals(id)).findFirst().orElse(null);
    }
}
