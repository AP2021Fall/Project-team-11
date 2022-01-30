package View;

import Controller.ProfileMenuController;
import Main.Main;
import Model.Member;
import Model.Team;
import Model.User;

import java.util.Scanner;

public class ProfileMenuView {
    private static ProfileMenuView profileMenuView = new ProfileMenuView();
    Scanner scanner = Main.getScanner();
    ProfileMenuController controller = new ProfileMenuController();
    public void run(){
        System.out.println("Welcome to Profile Menu");
        String input;
        while(!(input = scanner.nextLine()).equals("back")){
            String[] splitInput = input.split(" ");
            if(input.startsWith("Profile --change --oldPassword")){
                System.out.println(controller.changePassword(splitInput[3],splitInput[5]));
            }

            else if(input.startsWith("Profile --change --username")){
                System.out.println(controller.changeUsername(splitInput[3]));
            }

            else if(input.equals("Profile --showTeams")){
                User user = User.getLoggedInUser();
                for (Team team : user.getTeams()) {
                    System.out.println(team.getTeamName());
                }
            }

            else if(input.startsWith("Profile --showTeam ")){
                User user = User.getLoggedInUser();
                Team team = user.getTeamByTeamName(splitInput[2]);
                if(team == null){
                    System.out.println("Team doesn't exists!");
                    continue;
                }
                System.out.println(team.getTeamLeader().getUsername());
                if(!team.getTeamLeader().equals(user))
                    System.out.println(user.getUsername());
                for (Member member : team.getMembers()) {
                    if(!member.getUsername().equals(user.getUsername()))
                        System.out.println(member.getUsername());
                }
            }

            else if(input.equals("Profile --show --myProfile")){
                User user = User.getLoggedInUser();
                System.out.println(user.getUsername());
                System.out.println(user.getEmailAddress());
                System.out.println(user.getClass().getSimpleName());
            }

            else
                System.out.println("invalid command!");
        }
    }

    public static ProfileMenuView getProfileMenuView() {
        return profileMenuView;
    }

    private ProfileMenuView(){

    }
}
