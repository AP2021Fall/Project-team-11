package Main;

import View.LoginMenuView;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("welcome sry I dont know the current version");
        LoginMenuView.getLoginMenuView().run();
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
