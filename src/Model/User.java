package Model;

import java.util.ArrayList;

public class User {
    protected static ArrayList<User> users = new ArrayList<>();
    private static User loggedInUser;
    protected String username;
    protected String password;
    protected String emailAddress;
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



    public static User getUserWithEmail(String emailAddress){
        for (User user : users) {
            if(user.emailAddress.equals(emailAddress))
                return user;
        }
        return null;
    }
}
