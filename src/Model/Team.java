package Model;

import java.util.ArrayList;

public class Team {
    private static ArrayList<Team> teams = new ArrayList<>();
    private String teamName;
    private int teamId;
    private Leader teamLeader;
    private Date creationDate;
    private ArrayList<Member> members = new ArrayList<>();
    private static int idGenerator;

    public Team(String teamName, Leader teamLeader) {
        this.teamName = teamName;
        this.teamLeader = teamLeader;
        idGenerator++;
        this.teamId = idGenerator;
    }

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
        return teamId;
    }

    public void setTeamLeader(Leader teamLeader) {
        this.teamLeader = teamLeader;
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void deleteMember(Member member){
        members.remove(member);
    }

    public static Team getTeamWithTeamName (String teamName){
        for (Team team : teams) {
            if(teamName.equals(team.teamName))
                return team;
        }
        return null;
    }

    public static Team getTeamWithId (int id){
        for (Team team : teams) {
            if(id == team.teamId)
                return team;
        }
        return null;
    }
}
