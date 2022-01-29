package Model;

import java.util.ArrayList;

public class Board {
    //Board select +
    private static Board activeBoard ;
    private static ArrayList<Board> allBoards = new ArrayList<>();
    private String name;
    private int idGenerator = 100;
    private int id;
    private Team team;
    private final ArrayList <Task> boardTasks = new ArrayList<>();
    private ArrayList <Category> categories = new ArrayList<>();


    public Board(String name , Team team){
        this.name = name;
        this.id = idGenerator++;
        this.team = team;
        Category category = new Category("failed" , this);
        this.categories.add(category);
        Category category1 = new Category("done" , this);
        this.categories.add(category1);
        allBoards.add(this);
    }

    public static void removeBoard(Board board){
        //needs if for not existing
        allBoards.remove(board);
    }

    public boolean assignTask(Task task) {
        for (Task tasks:boardTasks){
            if (task.equals(tasks)){
                System.out.println("This task already exists on this board!");
                return false;
            }
        }
        boardTasks.add(task);
        return true;
    }

    public int getId(){return this.id;}

    public ArrayList<Category> getCategories(){return categories;}

    public void setActiveBoard(Board board){activeBoard = board;}

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
