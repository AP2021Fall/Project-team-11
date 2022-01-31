package View;

import java.util.Scanner;
import Main.Main;
import Model.User;

public class NotificationBarView {
    private static NotificationBarView notificationBarView = new NotificationBarView();

    public void run(){
        Scanner scanner = Main.getScanner();
        System.out.println("Welcome to Notification Menu");
        String input;
        while(!(input = scanner.nextLine()).equals("back")){
            if(input.equals("show notifications")){
                for(String notif :User.getLoggedInUser().getNotifications()){
                    System.out.println(notif);
                }
            }
        }
    }

    public static NotificationBarView getNotificationBarView() {
        return notificationBarView;
    }

    private NotificationBarView(){

    }
}
