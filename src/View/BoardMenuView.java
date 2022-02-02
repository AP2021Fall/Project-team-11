package View;

import java.util.Scanner;

import Controller.BoardMenuController;
import Main.Main;
import Model.*;

import java.util.regex.Matcher;

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
    private String setColumn = "board --category (\\w+) --column (\\d+)";
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
            if (User.getLoggedInUser() instanceof Leader) {
                if(input.matches(addNewBoardNamePattern)){
                    String name = splitInput[3];
                    if(selectedTeam.getBoardByName(name) != null){
                        System.out.println("Board already exists!");
                        continue;
                    }
                    new Board(name, selectedTeam);
                    System.out.println("Board added successfully");
                }

                else if(input.matches(removeBoardFromTeam)){
                    String name = splitInput[3];
                    Board board = selectedTeam.getBoardByName(name);
                    if(board == null){
                        System.out.println("Board doesn't exist!");
                    }
                    selectedTeam.removeBoardFromTeam(board);
                    System.out.println("Board removed successfully!");
                }

                else if(input.matches(selectBoard)){
                    System.out.println("ok");
                    String name = splitInput[3];
                    if(selectedTeam.getBoardByName(name)==null){
                        System.out.println("Board do not exists!");
                        continue;
                    }

                    selectedBoard =  selectedTeam.getBoardByName(name);
                    System.out.println("Board is selected");
                }

                else if(input.matches(deselectBoard)){
                    selectedBoard = null;
                    System.out.println("Board deselected");

                }

                else if(input.matches(newCategory)){

                    String name = splitInput[3];
                    System.out.println("ok");
                    System.out.println(BoardMenuController.addCategoryToBoard(name));
                }

                else if(input.matches(setColumn)){
                    String name = splitInput[2];
                    int column = Integer.parseInt(splitInput[4]);
                    System.out.println(BoardMenuController.moveCategoryToColumn(name,column));
                }

                else if(input.matches(done)){
                    if(selectedBoard.getCategories().isEmpty())
                    {
                        System.out.println("Please make a category first");
                        continue;
                    }
                    selectedBoard.setState(true);
                    System.out.println("Board is now ready!");
                }

                else if(input.matches(addTaskToBoard)){
                    System.out.println(BoardMenuController.addTaskToBoard(Integer.parseInt(splitInput[2])));
                }

                else if(input.matches(forceCategory)){

                }

                else if(input.matches(nextCategory)){
                    
                }

                else if(input.matches(showCategory)){

                }

                else if(input.matches(showDone)){

                }

                else if(input.matches(showFailed)){

                }

                else if(input.matches(showBoard)){
                    
                }


            } else
                System.out.println("You do not have the permission to do that action!");



        }
    }

    public static BoardMenuView getBoardMenuView() {
        return boardMenuView;
    }
    private int getTaskIdFromCommand(Matcher matcher){
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
