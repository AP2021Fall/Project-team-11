package View;


import Controller.LoginMenuController;
import Main.Main;

import java.util.Scanner;

public class LoginMenuView {
    private static LoginMenuView loginMenuView = new LoginMenuView();
    LoginMenuController controller = new LoginMenuController();
    Scanner scanner = Main.getScanner();
    String input;
    public void run(){
        while(!(input=scanner.nextLine()).isEmpty()){
            String [] splitInput = input.split(" ");

            if(input.startsWith("user create")){
                System.out.println(controller.createUser(splitInput[3],splitInput[5],splitInput[7],splitInput[9]));
            }

            else if(input.startsWith("user login")){
                String out = controller.logInUser(splitInput[3],splitInput[5]);
                System.out.println(out);
                if(out.equals("user logged in successfully!")){
                    MainMenuView.getMainMenuView().run();
                }

            }

            else
                System.out.println("invalid input");
        }
    }

    public static LoginMenuView getLoginMenuView() {
        return loginMenuView;
    }

    private LoginMenuView(){

    }
}
