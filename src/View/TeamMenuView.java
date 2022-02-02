package View;

import Controller.LoginMenuController;
import Main.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Controller.TeamMenuController;
import Main.Main;
import Model.Task;
import Model.Team;
import Model.User;

public class TeamMenuView {
    private static Team selectedTeam;
    private static TeamMenuView teamMenuView = new TeamMenuView();
    TeamMenuController controller = new TeamMenuController();
    Scanner scanner = Main.getScanner();
    String input;
    public void run(){
        System.out.println("TEAM MENU");
        ArrayList<Team> userTeams = User.getLoggedInUser().getTeams();
                    for(int i = 0 ; i < userTeams.size(); i++){
                        System.out.println((i+1) + " " + userTeams.get(i).getTeamName());
                    }
        while(!(input=scanner.nextLine()).equals("exit")){
            String [] splitInput = input.split(" ");

            try {

                if (input.equals("Scoreboard --show") && (selectedTeam) != null) {
                    ArrayList<String> output = controller.scoreBoard(selectedTeam); 
                    for(int i = 0 ; i < output.size();i++) {
                        System.out.println((i + 1) + output.get(i) + "\n");
                    }
                } else if (input.equals("Roadmap --show") && (selectedTeam) != null) {
                    ArrayList<String> output = controller.roadMap(selectedTeam);
                    if(output != null){
                        for (int i = 0 ; i < output.size() ; i++){
                            System.out.println((i+1)+ output.get(i) + "\n");
                        }
                    }
                    else{
                    System.out.println("no task yet");
                    }
                } else if(input.startsWith("Enter team")){
                    String name = splitInput[2];
                    selectedTeam = Team.getTeamWithTeamName(name);
                    if(selectedTeam == null){
                        System.out.println("Invalid Team name");
                    }else{
                        System.out.println("Selected team succussfully changed to :" + selectedTeam.getTeamName());
                    }

                }else if(input.equals("Chatroom --show") && (selectedTeam) != null){
                    Map<String , User> allChats = new HashMap<>(selectedTeam.getChats());
                    for(String chat : allChats.keySet()){
                        System.out.println(allChats.get(chat) +" : " + chat);
                    }
                    if (allChats.size() == 0){
                        System.out.println("no message yet");}
                }else if(input.startsWith("send --message")){
                    String chatText = "";
                    for(int i = 2 ; i < splitInput.length ; i++)
                        chatText += " " + splitInput[i];
                    selectedTeam.addChats(chatText, User.getLoggedInUser());

                    Map<String , User> allChats = new HashMap<>(selectedTeam.getChats());
                    for(String chat : allChats.keySet()){
                        System.out.println(allChats.get(chat) +" : " + chat);
                    }
                }else if(input.equals("show tasks") && (selectedTeam) != null){
                    ArrayList<Task> alltasks = selectedTeam.getAllTasks();
                    for(int i = 0 ; i < alltasks.size() ;i++){
                        System.out.println(i+1 + "-\n" + alltasks.get(i));
                    }
                }else if(input.equals("enter board menu")){
                    BoardMenuView.getBoardMenuView().run();
                }else if((input.startsWith("send notification --team")) && User.getLoggedInUser().isLeader){
                    String[] notification = input.split(" ");
                    String message ="";
                    for(int i = 3 ; i  < notification.length ; i++){
                        message += notification[i] + " ";
                    }
                    for(User user : selectedTeam.getMembers()){
                        User.addNotification(message, user);
                    }
                    
                }else if((input.startsWith("send notification --user")) && User.getLoggedInUser().isLeader){
                    String[] notification = input.split(" ");
                    String message ="";
                    for(int i = 4 ; i  < notification.length ; i++){
                        message += notification[i] + " ";
                    }
                    User.addNotification(message, User.getUserWithUserName(splitInput[3]));
                }
                else System.out.println("not doable , due to unacceptable selected team or invalid command");

            }catch (Exception e){
                System.out.println("invalid input");}
        }

    }

    public static TeamMenuView getTeamMenuView() {
        return teamMenuView;
    }

    public static Team getSelectedTeam(){return selectedTeam;}

    private TeamMenuView(){

    }
}

