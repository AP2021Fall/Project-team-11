package Model;

import java.util.ArrayList;

public class Team {
    private static ArrayList<Team> teams = new ArrayList<>();
    private String teamName;
    private int teamNumber;
    private Leader teamLeader;
    private Date creationDate;
    private ArrayList<Member> members = new ArrayList<>();
    private final ArrayList<Team> allTasks = new ArrayList<>();



    public static ArrayList<Team> getTeams() {
        return teams;
    }

    public String getTeamName() {
        return teamName;
    }

    public Leader getTeamLeader() {
        return teamLeader;
    }


    public ArrayList<Member> getMembers() {
        return members;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getTeamNumber() {
        return teamNumber;
    }
}
