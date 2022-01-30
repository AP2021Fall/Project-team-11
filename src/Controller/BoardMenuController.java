package Controller;

import java.util.ArrayList;

import Model.*;
import View.TeamMenuView;

public class BoardMenuController {


    public String addCategory(String name , int column){
        Category category = Board.getActiveBoard().getCategoryByName(name);
        if (category.equals(null)){
            //view handler
            return "NO Category with this name";
        }
        else {
            try {
                Board.getActiveBoard().getCategories().add(column - 1,category);
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

    public void addScores(){

    }


}
