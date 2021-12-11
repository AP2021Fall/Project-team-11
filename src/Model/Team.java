package Model;

import java.util.ArrayList;

public class Team {
    private static ArrayList<Team> teams = new ArrayList<>();
    private String teamName;
    private int teamNumber;
    private Leader teamLeader;
    private Date creationDate;
    private ArrayList<Member> members = new ArrayList<>();


    public static ArrayList<Team> getTeams() {
        return teams;
    }
}
