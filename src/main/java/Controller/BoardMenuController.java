package Controller;

import java.util.ArrayList;

import Model.*;
import View.BoardMenuView;
import View.TeamMenuView;

public class BoardMenuController {

    private static Board selectedBoard = BoardMenuView.getSelectedBoard();
    public static String moveCategoryToColumn(String name , int column){
        Category category = selectedBoard.getCategoryByName(name);
        if (category == null){
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
        Task theTask = TeamMenuView.getSelectedTeam().getTaskWithId(taskID);
        if(theTask == null){
            return "This task doesn't exist in your team";
        }
        return selectedBoard.addTaskToBoard(theTask);

    }

    public static String addCategoryToBoard(String name){
        if(selectedBoard.getCategoryByName(name) !=null)
            return "This category already exists on board!";
        Category category = new Category(name, selectedBoard);
        System.out.println("ok");
        selectedBoard.addCategory(category);
        return "Category" + category.getName() + " successfully added to selected board" ;
    }
}