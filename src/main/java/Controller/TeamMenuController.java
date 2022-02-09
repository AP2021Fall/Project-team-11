package Controller;

import Model.Member;
import Model.Task;
import Model.Team;
import Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TeamMenuController {
    private static Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> scoreBoard(Team team){
        HashMap <Member , Integer> scores= team.getTeamMembersScores();
        ArrayList<String> output = new ArrayList<>();
        for (Member member: scores.keySet()) {
            output.add(member.getUsername() + " : "+ scores.get(member));
        }
        return output;
    }

   public ArrayList<String> roadMap(Team team){
        ArrayList<String> output = new ArrayList<>();
        if(team.getAllTasks().size() == 0)
            return null;
        for (Task task : team.getAllTasks() ){
            output.add(task.getTitle() + " : " + task.getProgressPercentage() +"% done");
        }
        return output;
    }

    public void addNotificationForUser(String message , String name){
        User.addNotification(message, User.getUserWithUserName(name));
    }

    public void addNotificationForTeam(String message , Team team){
        for(User user : team.getMembers()){
            User.addNotification(message, user);
        }
    }

}
