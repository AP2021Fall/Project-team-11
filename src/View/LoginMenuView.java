package View;


import Controller.LoginMenuController;
import Main.Main;

import java.util.Scanner;

public class LoginMenuView {
    LoginMenuController controller = new LoginMenuController();
    Scanner scanner = Main.getScanner();
    String input;
    public void run(){
        while(!(input=scanner.nextLine()).isEmpty()){
            String [] splitInput = input.split(" ");

            if(input.startsWith("user create")){
                System.out.println(controller.createUser(splitInput[2],splitInput[3],splitInput[4],splitInput[5]));
            }

            else if(input.startsWith("user login")){

            }

            else
                System.out.println("invalid input");
        }
    }
}
