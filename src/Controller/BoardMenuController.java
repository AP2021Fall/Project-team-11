package Controller;

import Model.*;

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

}
