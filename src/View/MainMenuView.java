package View;

import Main.Main;
import Model.User;

import java.util.Scanner;

public class MainMenuView {
    private static MainMenuView mainMenuView = new MainMenuView();
    Scanner scanner = Main.getScanner();
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

            else if(input.equals("logout")){
                User.setLoggedInUser(null);
                return;
            }

            else
                 System.out.println("invalid command");
        }

    }


    public static MainMenuView getMainMenuView() {
        return mainMenuView;
    }

    private MainMenuView(){

    }
}
