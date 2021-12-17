package Model;

import java.util.ArrayList;

public class Task extends Date {
    private static ArrayList<Task> allTasks = new ArrayList<>();
    private int id;
    private String title;
    private String Description;
    private Date creation;
    private Date  deadline;
    private ArrayList<User>  assignedUsers = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>();

    enum  Priority{
        Highest, High, Low, Lowest
    }




    public Task(int id, String title, String description, Date dateAndTimeOfCreation, Date dateAndTimeOfDeadline, ArrayList<User> assignedUsers, ArrayList<String> comments) {
        this.id = id;
        this.title = title;
        Description = description;
        this.assignedUsers = assignedUsers;
        this.comments = comments;
    }

    public Task(Date dateAndTimeOfCreation, Date dateAndTimeOfDeadline) {
        this.deadline = dateAndTimeOfDeadline;
    }

    public static ArrayList<Task> getAllTasks() {
        return allTasks;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return Description;
    }

    public Date getCreation() {
        return creation;
    }

    public Date getDeadline() {
        return deadline;
    }

    public ArrayList<User> getAssignedUsers() {
        return assignedUsers;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setAssignedUsers(ArrayList<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public static void setAllTasks(ArrayList<Task> allTasks) {
        Task.allTasks = allTasks;
    }

    public static Task getTaskById(int id) {
        for (Task task : allTasks) {
            if (task.id == id) return task;
        }
        return null;
    }
    public void updateTitle(int id, String newTitle){
        getTaskById(id).title = newTitle;
    }

    public void updateDescription(int id, String newDescription){
        getTaskById(id).title = newDescription;
    }

    public void updatePriority(int id, String newPriority){


    }

    public void updateDeadline(int id, Date newDeadline){
        getTaskById(id).deadline = newDeadline;
    }

    public void removeUsers(int id, String username){
        getTaskById(id).assignedUsers.remove(User.getUserWithUserName(username));
    }

    public void addUser(int id, String username){
        getTaskById(id).assignedUsers.add(User.getUserWithUserName(username));
    }
}
