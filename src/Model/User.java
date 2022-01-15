package Model;

import java.util.ArrayList;

public class User {
    public static boolean isLeader;
    protected static ArrayList<User> users = new ArrayList<>();
    private static User loggedInUser;
    protected String username;
    protected String password;
    protected String emailAddress;
    protected Team selectedTeam;
    protected int score;
    protected ArrayList<Team> teams = new ArrayList<>();


    public User(String username, String password, String emailAddress) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
    }

    public static User getUserWithUserName(String username){
        for (User user : users) {
            if(user.username.equals(username))
                return user;
        }
        return null;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static User getUserWithEmail(String emailAddress){
        for (User user : users) {
            if(user.emailAddress.equals(emailAddress))
                return user;
        }
        return null;
    }


    public ArrayList<Team> getTeams() {
        return teams;
    }

    public Team getTeamByTeamName(String teamName){
        for (Team team : teams) {
            if(team.getTeamName().equals(teamName))
                return team;
        }
        return null;
    }

    public Team getSelectedTeam() {
        return selectedTeam;
    }

    public void setSelectedTeam(Team selectedTeam) {
        this.selectedTeam = selectedTeam;
    }

    protected ArrayList<Task> tasks = new ArrayList<>();


    public ArrayList<Task> getTasks(){ return  this.tasks ;}
}
