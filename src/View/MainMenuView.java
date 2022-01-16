package View;

import Controller.MainMenuController;
import Main.Main;
import Model.*;

import java.util.ArrayList;
import java.util.Collections;
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

                if(selectedTeam!=null){

                    if(input.startsWith("sudo show")){
                        ArrayList<Task> tasks= selectedTeam.getAllTasks();
                        Collections.sort(tasks);
                        for (Task task : tasks) {
                            System.out.println(task.getTitle());
                        }
                    }

                    if(input.startsWith("create task")){
                        System.out.println(controller.createTask(splitInput[3],splitInput[5],splitInput[7]));
                    }

                    if(input.startsWith("show --members")){
                        ArrayList<Member> members = selectedTeam.getMembers();
                        Collections.sort(members);
                        for (Member member : members) {
                            System.out.println(member.getUsername());
                        }
                    }

                    if(input.startsWith("Add member")){
                        System.out.println(controller.addMember(splitInput[3]));
                    }

                    if(input.startsWith("delete member")){
                        System.out.println(controller.deleteMember(splitInput[3]));
                    }

                    if(input.startsWith("assign member")){
                        System.out.println(controller.assignTask(splitInput[3],splitInput[5]));
                    }
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

    public static Team getSelectedTeam() {
        return selectedTeam;
    }

    private MainMenuView(){

    }
}
