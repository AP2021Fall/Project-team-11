package View;

import java.util.ArrayList;

public class TeamMenuView {
    private static TeamMenuView teamMenuView = new TeamMenuView();
    public void run(){

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
