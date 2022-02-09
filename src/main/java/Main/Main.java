package Main;

import Model.Admin;
import Model.User;
import View.LoginMenuView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.application.Application.launch;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("JIRA PROJECT V.1");
        User.getUsers().add(new Admin("Admin","123456","admin@gmail.com"));
        launch();
    }

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LoginMenuView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
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
