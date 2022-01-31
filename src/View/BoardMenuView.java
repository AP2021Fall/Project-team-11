package View;

import java.util.Scanner;

import Controller.BoardMenuController;
import Main.Main;
import Model.Board;
import Model.Team;
import Model.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Model.Team;

public class BoardMenuView {
    private static Board selectedBoard;
    private static Team selectedTeam = TeamMenuView.getSelectedTeam();
    private boolean loggedInUserIsLeader = User.getLoggedInUser().isLeader;
    private static BoardMenuView boardMenuView = new BoardMenuView();
    private String addNewBoardNamePattern = "board --new --name (\\w+)";
    private String removeBoardFromTeam = "board --remove --name (\\w+)";
    private String selectBoard = "board --select --name (\\w)";
    private String deselectBoard = "board --deselect";
    private String newCategory = "board --new --category (\\w+)";
    private String setColumn = "board --category (\\w+) --column (\\w+)";
    private String done = "board --done";
    private String addTaskToBoard = "board --add (\\w+)";
    private String forceCategory = "board --force --category (\\w+) --task(\\w+)";
    private String nextCategory = "board --category next --task(\\w+)";
    private String showCategory = "board --show --category (\\w+)";
    private String showDone = "board --show done";
    private String showFailed = "board --show failed";
    private String showBoard = "board --show";


    Scanner scanner = Main.getScanner();
    BoardMenuController controller = new BoardMenuController();
    public void run(){
        System.out.println("Board MENU");
        String input;
        while(!(input = scanner.nextLine()).equals("back")){
            String[] splitInput = input.split(" ");
            if (loggedInUserIsLeader){
                if(input.matches(addNewBoardNamePattern)){
                    String name = splitInput[3];
                    for(Board board :selectedTeam.getBoards()){
                        if(board.getName() == name){
                            System.out.println("There is already a board with this name");
                        }
                        else{
                            Board board1 = new Board(name, selectedTeam);
                        }
                }
                if(input.matches(removeBoardFromTeam)){
                    TeamMenuView.getSelectedTeam().removeBoardFromTeam(TeamMenuView.getSelectedTeam().getBoardByName(getBoardName(Main.getMatcher(input, removeBoardFromTeam))));
                }
                if(input.matches(selectBoard)){
                    selectedBoard = selectedTeam.getBoardByName(getBoardName(Main.getMatcher(input, selectBoard)));
                }
                if(input.matches(deselectBoard)){
                    selectedBoard = null;

                }
                if(input.matches(newCategory)){
                    System.out.println(BoardMenuController.addCategorysBoard(getBoardName(Main.getMatcher(input, newCategory))));
                }
                if(input.matches(setColumn)){

                }
                if(input.matches(done)){
                    
                }
                if(input.matches(addTaskToBoard)){
                    System.out.println(BoardMenuController.addTaskToBoard(getTaskIdfromCommand(Main.getMatcher(input, addTaskToBoard))));
                }
                if(input.matches(forceCategory)){

                }
                if(input.matches(nextCategory)){
                    
                }
                if(input.matches(showCategory)){

                }
                if(input.matches(showDone)){

                }
                if(input.matches(showFailed)){

                }
                if(input.matches(showBoard)){
                    
                }

            }else if (input.startsWith("board --new --name")){
                System.out.println("You do not have the permission to do that action!");
            }
            }
        }
    }

    public static BoardMenuView getBoardMenuView() {
        return boardMenuView;
    }
    private int getTaskIdfromCommand(Matcher matcher){
        matcher.find();
        return Integer.parseInt(matcher.group(1));
    }

    private BoardMenuView(){

    }
    private String getBoardName(Matcher matcher){
        matcher.find();
        return matcher.group(1);
    }

    public static Board getSelectedBoard(){return selectedBoard;}
}
