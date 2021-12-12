package View;

import Controller.ProfileMenuController;
import Main.Main;

import java.util.Scanner;

public class ProfileMenuView {
    private static ProfileMenuView profileMenuView = new ProfileMenuView();
    Scanner scanner = Main.getScanner();
    ProfileMenuController controller = new ProfileMenuController();
    public void run(){
        String input;
        while(!(input = scanner.nextLine()).equals("back")){
            String[] splitInput = input.split(" ");
            if(input.startsWith("Profile --change --oldPassword")){
                System.out.println(controller.changePassword(splitInput[3],splitInput[5]));
            }

            if(input.startsWith("Profile --change --username")){
                System.out.println(controller.changeUsername(splitInput[3]));
            }
        }
    }

    public static ProfileMenuView getProfileMenuView() {
        return profileMenuView;
    }

    private ProfileMenuView(){

    }
}
