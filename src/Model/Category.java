package Model;

import java.util.ArrayList;

public class Category {
    private static int idGenerator = 1;
    private final int id;
    private final String name;
    private final Board board;
    ArrayList<Task> tasks = new ArrayList<>();


    public Category(String name ,Board board){
        this.name = name;
        this.board = board;
        this.id = idGenerator++;
    }

    public void assignTask(Task task){this.tasks.add(task);}

    public String getName(){return name;}

}
