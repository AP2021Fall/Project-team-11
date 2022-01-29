package View;

import Controller.LoginMenuController;
import Main.Main;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.TeamMenuController;
import Main.Main;
import Model.Team;

public class TeamMenuView {
    private Team selectedTeam;
    private static TeamMenuView teamMenuView = new TeamMenuView();
    TeamMenuController controller = new TeamMenuController();
    Scanner scanner = Main.getScanner();
    String input;
    public void run(){
        while(!(input=scanner.nextLine()).equals("exit")){
            String [] splitInput = input.split(" ");
            try {

                if (input.startsWith("Scoreboard")) {
                    ArrayList<String> output = controller.scoreBoard(selectedTeam); //team
                    for(int i = 0 ; i < output.size();i++) {
                        System.out.println((i + 1) + output.get(i) + "\n");
                    }
                } else if (input.startsWith("Roadmap")) {
                    ArrayList<String> output = controller.scoreBoard(selectedTeam); //team
                    for (int i = 0 ; i < output.size() ; i++){
                        System.out.println((i+1)+ output.get(i) + "\n");
                    }
                }
                else System.out.println("invalid input");

            }catch (Exception e){
                System.out.println("invalid input");}
        }

    }
    public void scoreBoardView(ArrayList<String> output){
        for(int i = 0 ; i < output.size();i++){
            System.out.println((i+1)+ output.get(i) +"\n");
        }
    }
    public void roadMapView(ArrayList<String> output){
        for (int i = 0 ; i < output.size() ; i++){
            System.out.println((i+1)+ output.get(i) + "\n");
        }
    }

    public static TeamMenuView getTeamMenuView() {
        return teamMenuView;
    }

    private TeamMenuView(){

    }
}
