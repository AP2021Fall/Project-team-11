package Model;

import java.util.ArrayList;

public class Board {
    private String name;
    //Board select +
    private static Board activeBoard ;
    private final ArrayList <Task> boardTasks = new ArrayList<>();
    private ArrayList <Category> columns = new ArrayList<>();

    public Board(String name){
        this.name = name;
        Category category = new Category("failed");
        this.columns.add(category);
        Category category1 = new Category("done");
        this.columns.add(category1);
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

}

class Category{
    private static int idGenerator = 1;
    private int id;
    private String name;
    ArrayList<Task> categoryTasks = new ArrayList<>();


    public Category(String name){
        this.name = name;
        this.id = idGenerator;
        idGenerator++;
    }
}