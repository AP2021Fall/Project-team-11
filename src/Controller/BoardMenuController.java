package Controller;

import java.util.ArrayList;

import Model.*;
import View.TeamMenuView;
import View.BoardMenuView;

public class BoardMenuController {


    public static String addCategoryToBoard(String name , int column){
        Category category = Board.getActiveBoard().getCategoryByName(name);
        if (category.equals(null)){
            //view handler
            return "NO Category with this name";
        }
        else {
            try {
                BoardMenuView.getSelectedBoard().getCategories().add(column - 1,category);
            }catch (Exception e){
                return "Wrong column";
            }
        }
        return "Category" + name + " added to column" + column;
    }

    public static String addTaskToBoard(int taskID){
        ArrayList<Task> allTasks = new ArrayList<>(TeamMenuView.getSelectedTeam().getAllTasks());
        Task theTask = TeamMenuView.getSelectedTeam().getTaskWithId(taskID);
        if(theTask.equals(null)){
            return "This task doesn't exist in your team";
        }
        return Board.getActiveBoard().addTaskToBoard(theTask);

    }

    public static String addCategorysBoard(String name){
        if(name == BoardMenuView.getSelectedBoard().getCategoryByName(name).getName()){
            return "This category already exists on board!";
        }
        else{
        Category category = new Category(name, BoardMenuView.getSelectedBoard());
        BoardMenuController.addCategoryToBoard(category.getName() , 1);
            return "Category" + category.getName() + " successdully added to selected board" ;
        }
    }


}
