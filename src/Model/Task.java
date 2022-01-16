package Model;

import java.util.ArrayList;

public class Task implements Comparable{
    private static ArrayList<Task> allTasks = new ArrayList<>();
    private int id;
    private String title;
    private String description;
    private Date startTime;
    private Date deadline;
    private ArrayList<User>  assignedUsers = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>();
    private Team taskTeam;
    private static int lastId;

    @Override
    public int compareTo(Object o) {
        return this.startTime.compareTo(((Task)o).startTime);
    }


    public Task(String title, Date startTime, Date deadline, Team taskTeam) {
        this.title = title;
        this.startTime = startTime;
        this.deadline = deadline;
        this.id = ++lastId;
        this.taskTeam=taskTeam;
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
        return description;
    }

    public Date getStartTime() {
        return startTime;
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
        description = description;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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

    public static Task getTaskByTitle(String title){
        for (Task task : allTasks) {
            if(task.title.equals(title))
                return task;
        }
        return null;
    }

}
