package Main;

import Model.Admin;
import Model.User;
import View.LoginMenuView;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("JIRA PROJECT V.1");
        User.getUsers().add(new Admin("Admin","123456","admin@gmail.com"));
        LoginMenuView.getLoginMenuView().run();
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static boolean checkMatching(String input , String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public static Matcher getMatcher(String command, String regex) {
        return Pattern.compile(regex).matcher(command);
    }
}
