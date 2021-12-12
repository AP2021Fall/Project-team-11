package Main;

import View.LoginMenuView;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("welcome sry I dont know the current version");
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
}
