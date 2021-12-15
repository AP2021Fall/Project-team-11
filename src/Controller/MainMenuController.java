package Controller;

import Main.Main;
import Model.Admin;
import Model.Leader;
import Model.Team;
import Model.User;
import View.MainMenuView;

public class MainMenuController {

    public String createTeam(String teamName){
        if(Team.getTeamWithTeamName(teamName) != null)
            return "There is another team with this name!";
        if(teamName.length()<5 || teamName.length()>12 || !Main.checkMatching(teamName,".*[A-Z].*") || !Main.checkMatching(teamName,".+\\d.*"))
            return "Team name is invalid!";
        Admin.addTeam(new Team(teamName, (Leader) User.getLoggedInUser()));
        return "Team created successfully! Waiting For Admin’s confirmation…";

    }

    public String showTeam(String teamIdOrName){
        int teamId=0;
        boolean flag = false;
        try {
            teamId = Integer.parseInt(teamIdOrName);
            flag = true;
        }
        catch (NumberFormatException ignored) {
        }
        Team team;
        if(flag)
            team = Team.getTeamWithId(teamId);
        else
            team = Team.getTeamWithTeamName(teamIdOrName);
        if(team == null)
            return "Team not found!";
        MainMenuView.setSelectedTeam(team);
        return "team found!";

    }
}
