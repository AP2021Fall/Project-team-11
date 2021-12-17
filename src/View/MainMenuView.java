package View;

import Controller.MainMenuController;
import Main.Main;
import Model.Leader;
import Model.Team;
import Model.User;

import java.util.Scanner;

public class MainMenuView {
    private static MainMenuView mainMenuView = new MainMenuView();
    MainMenuController controller = new MainMenuController();
    Scanner scanner = Main.getScanner();
    private static Team selectedTeam;
    String input;
    public void run(){
        while(!(input = scanner.nextLine()).isEmpty()){
            if(input.startsWith("enter menu")) {
                String menuName = input.split(" ")[2];

                if (menuName.equalsIgnoreCase("Profile")) {
                    ProfileMenuView.getProfileMenuView().run();
                }

                else if (menuName.equalsIgnoreCase("Team")) {
                    TeamMenuView.getTeamMenuView().run();
                }

                else if (menuName.equalsIgnoreCase("Tasks")) {
                    TaskPageView.getTaskPageView().run();
                }

                else if (menuName.equalsIgnoreCase("Calendar")) {
                    CalenderMenuView.getCalenderMenuView().run();
                }

                else if (menuName.equalsIgnoreCase("Notification")) {
                    NotificationBarView.getNotificationBarView().run();
                }
                else
                    System.out.println("invalid menu name");
            }

            else if(User.getLoggedInUser() instanceof Leader){

                User user = User.getLoggedInUser();
                String[] splitInput = input.split(" ");

                if(input.equals("show --teams")){
                    for (Team team : user.getTeams())
                        System.out.println(team.getTeamName());

                }

                else if(input.startsWith("create --team")){
                    System.out.println(controller.createTeam(splitInput[2]));
                }

                else if(input.startsWith("show --team")){
                    System.out.println(controller.showTeam(splitInput[2]));
                }
            }


            else if(input.equals("logout")){
                User.setLoggedInUser(null);
                return;
            }

            else
                 System.out.println("invalid command");
        }

    }

    public static void setSelectedTeam(Team selectedTeam) {
        MainMenuView.selectedTeam = selectedTeam;
    }

    public static MainMenuView getMainMenuView() {
        return mainMenuView;
    }

    private MainMenuView(){

    }
}
