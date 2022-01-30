package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.CalenderMenuController;
import Main.Main;

public class CalenderMenuView {
    private static CalenderMenuView calenderMenuView = new CalenderMenuView();
    Scanner scanner = Main.getScanner();
    CalenderMenuController controller = new CalenderMenuController();
    public void run(){
        System.out.println("Welcome to Calender Menu");
        String input;
        while(!(input = scanner.nextLine()).equals("back")){
            if(input.equals("calendar --show deadlines")){
                ArrayList <String> deadlines = new ArrayList<>(controller.getFormattedDeadlines());
                for (int i = 0 ; i < deadlines.size(); i ++) {
                    System.out.println(i+1 + " : " + deadlines.get(i));
                }
            }else{
                System.out.println("invalid command!");
            }
        }

    }

    public static CalenderMenuView getCalenderMenuView() {
        return calenderMenuView;
    }

    private CalenderMenuView(){

    }
}
