package Classes;

import java.util.List;

public class Team extends Entity{
   public User teamLead;
   public String name;
   public String gitHubLink;

   public static void copyTeam(Team sourceTeam, Team destinationTeam) {
      destinationTeam.teamLead = sourceTeam.teamLead;
      destinationTeam.name = sourceTeam.name;
      destinationTeam.gitHubLink= sourceTeam.gitHubLink;
      destinationTeam.updated = sourceTeam.updated;
   }

   public static Team findById(List<Team> teams, String id) {
      return teams.stream().filter(t -> t.id.equals(id)).findFirst().orElse(null);
   }
}
