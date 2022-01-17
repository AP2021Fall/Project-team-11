package Model;

import java.util.ArrayList;

public class Admin extends User{
    private static ArrayList<Team> pendingTeams = new ArrayList<>();


    public Admin(String username, String password, String emailAddress) {
        super(username, password, emailAddress);
    }


    public static ArrayList<Team> getPendingTeams() {
        return pendingTeams;
    }

    public static void addPendingTeam(Team team){
        pendingTeams.add(team);
    }

    public static Team getTeamByName(String name){
        for (Team team : pendingTeams) {
            if(team.getTeamName().equals(name))
                return team;
        }
        return null;
    }

    public static void removeTeam(Team team){
        pendingTeams.remove(team);
    }
}
