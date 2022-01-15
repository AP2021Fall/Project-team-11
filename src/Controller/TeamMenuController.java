package Controller;

import Model.Member;
import Model.Task;
import Model.Team;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamMenuController {

    public ArrayList<String> scoreBoard(Team team){
        HashMap <Member , Integer> scores= team.getTeamMembersScores();
        ArrayList<String> output = new ArrayList<>();
        for (Member member: scores.keySet()) {
            output.add(member.getUsername() + " : "+ scores.get(member));
        }
        return output;
    }

    public ArrayList<String> roadMap(Team team){
        ArrayList<String> output = new ArrayList<>();
        for (Task task : team.getAllTasks() ){
            output.add(task.getTitle() + " : " + task.getProgressPercentage() +"% done");
        }
        return output;
    }

}
