package View;

import java.util.Scanner;

import Controller.BoardMenuController;
import Main.Main;
import Model.Board;
import Model.Team;
import Model.User;

public class BoardMenuView {
    private static Team selectedTeam = TeamMenuView.getSelectedTeam();
    private boolean loggedInUserIsLeader = User.getLoggedInUser().isLeader;
    private static BoardMenuView boardMenuView = new BoardMenuView();
    Scanner scanner = Main.getScanner();
    BoardMenuController controller = new BoardMenuController();
    public void run(){
        String input;
        while(!(input = scanner.nextLine()).equals("back")){
            String[] splitInput = input.split(" ");
            if((input.startsWith("board --new --name") && loggedInUserIsLeader)){
                String name = splitInput[3];
                for(Board board :selectedTeam.getBoards()){
                    if(board.getName() == name){
                        System.out.println("There is already a board with this name");
                    }
                    else{
                        Board board1 = new Board(name, selectedTeam);
                    }
                }
            }else if (input.startsWith("board --new --name")){
                System.out.println("You do not have the permission to do that action!");
            }
        
        }
    }

    public static BoardMenuView getBoardMenuView() {
        return boardMenuView;
    }

    private BoardMenuView(){

    }
}
