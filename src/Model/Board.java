package Model;

import java.util.ArrayList;

import View.TeamMenuView;

public class Board {
    //Board select +
    private static Board activeBoard ;
    private String name;
    private int idGenerator = 100;
    private int id;
    private Team team;
    private boolean state;
    private final ArrayList <Task> boardTasks = new ArrayList<>();
    private ArrayList <Category> categories = new ArrayList<>();


    public Board(String name , Team team){
        this.name = name;
        this.state = false;
        this.id = idGenerator++;
        this.team = team;
        Category category = new Category("failed" , this);
        this.categories.add(category);
        Category category1 = new Category("done" , this);
        this.categories.add(category1);
        TeamMenuView.getSelectedTeam().getBoards().add(this);
    }

    public static void removeBoard(Board board){
        TeamMenuView.getSelectedTeam().getBoards().remove(board);
    }

    public String addTaskToBoard(Task task) {
        for (Task tasks:boardTasks){
            if (task.equals(tasks)){
                return "This task already exists on this board!";
            }
        }
        boardTasks.add(task);
        return "Successfully added!";
    }

    public int getId(){return this.id;}

    public ArrayList<Category> getCategories(){return categories;}

    public static void setActiveBoard(Board board){activeBoard = board;}

    public void setState(Boolean state){this.state = state;}

    public static Board getActiveBoard(){return activeBoard;}


    public String getName(){return this.name;}

    public Category getCategoryByName(String name){
        for (Category category : this.getCategories()){
            if (category.getName().equals(name)){
                return category;
            }
        }
        return null;
    }
    


}
