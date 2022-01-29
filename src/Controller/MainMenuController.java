package Controller;

import Main.Main;
import Model.*;
import View.MainMenuView;

import java.util.ArrayList;

public class MainMenuController {

    public String createTeam(String teamName){
        if(Team.getTeamWithTeamName(teamName) != null)
            return "There is another team with this name!";
        if(teamName.length()<5 || teamName.length()>12 || !Main.checkMatching(teamName,".*[A-Z].*") || !Main.checkMatching(teamName,".+\\d.*"))
            return "Team name is invalid!";
        Admin.addPendingTeam(new Team(teamName, (Leader) User.getLoggedInUser()));
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
            team = User.getLoggedInUser().getTeamWithId(teamId);
        else
            team = User.getLoggedInUser().getTeamByTeamName(teamIdOrName);
        if(team == null)
            return "Team not found!";
        MainMenuView.setSelectedTeam(team);
        return "team found!";
    }

    public String createTask(String title, String startTime, String deadline) {
        Task task = Task.getTaskByTitle(title);
        if(task!=null)
            return "There is another task with this title!";
        if(!startTime.matches("((\\d{4}-\\d{2}-\\d{2})\\|(([0-1]\\d)|(2[0-3])):[0-5]\\d)"))
            return "Invalid start date!";
        if(!deadline.matches("((\\d{4}-\\d{2}-\\d{2})\\|(([0-1]\\d)|(2[0-3])):[0-5]\\d)"))
            return "Invalid deadline!";

        Date startDate = new Date(startTime);
        Date endDate = new Date(deadline);
        MainMenuView.getSelectedTeam().addTask(new Task(title,startDate,endDate,MainMenuView.getSelectedTeam()));

        return "Task created successfully!";
// It's not necessary right now, but I should probably add task to all tasks

    }

    public String addMember(String username) {
        User member = User.getUserWithUserName(username);
        if(!(member instanceof Member))
            return "No user exists with this username !";
        MainMenuView.getSelectedTeam().addMember((Member) member);
        member.addTeam(MainMenuView.getSelectedTeam());
        return  "Member added successfully !";

    }

    public String deleteMember(String username) {
        Member member = MainMenuView.getSelectedTeam().getMembersWithUsername(username);
        if(member == null)
            return "No user exists with this username !";
        MainMenuView.getSelectedTeam().deleteMember(member);
        member.deleteTeam(MainMenuView.getSelectedTeam());
        return "Member deleted successfully !";
    }

    public String assignTask(String id, String username) {
        Member member = MainMenuView.getSelectedTeam().getMembersWithUsername(username);
        Task task = MainMenuView.getSelectedTeam().getTaskWithId(Integer.parseInt(id));
        if(member == null)
            return "No user exists with this username !";
        if(task == null)
            return "No Task exists with this id!";
        member.addTask(task);
        task.addMember(member);
        return "Member Assigned Successfully!";

    }

    public String acceptTeams(String[] inputs) {
        ArrayList<Team> teams = new ArrayList<>();
        for(int i=2;i<inputs.length;i++){
            Team team = Admin.getTeamByName(inputs[i]);
            if(team == null)
                return "Some teams are not in pending status! Try again";
            teams.add(team);
        }
        for (Team team : teams) {
            Team.addTeam(team);
            team.getTeamLeader().addTeam(team);
            Admin.removeTeam(team);
        }
        return "Accepted pending teams !";
    }

    public String rejectTeams(String[] inputs){
        ArrayList<Team> teams = new ArrayList<>();
        for(int i=2;i<inputs.length;i++){
            Team team = Admin.getTeamByName(inputs[i]);
            if(team == null)
                return "Some teams are not in pending status! Try again";
            teams.add(team);
        }
        for (Team team : teams) {
            Admin.removeTeam(team);
        }

        return "Rejected pending teams !";
    }

    public String changeRole(String username, String role) {
        User user = User.getUserWithUserName(username);
        if(user == null || user.equals(User.getLoggedInUser()))
            return "There is no user with this username";
        if(!role.equalsIgnoreCase("Member") || !role.equalsIgnoreCase("Leader"))
            return "Invalid role";
        if(user instanceof Member && role.equalsIgnoreCase("Member") || user instanceof Leader && role.equalsIgnoreCase("Leader"))
            return "User already have this role";
        if(user instanceof Member){
            User.getUsers().remove(user);
            User.getUsers().add(new Leader(user.getUsername(),user.getPassword(),user.getEmailAddress()));
            for (Team team : user.getTeams()) {
                team.deleteMember((Member) user);
            }
            for (Task task : user.getTasks()) {
                task.removeMember((Member) user);
            }
            user.getTeams().clear();
            user.getTasks().clear();
        }
        return "Role changed successfully";

    }
}
