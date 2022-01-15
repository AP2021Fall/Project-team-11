package Model;


import java.util.ArrayList;

public class Task {
    private static ArrayList<Task> allTasks = new ArrayList<>();
    private int id;
    private String title;
    private String description;
    private TaskPriority priority;
    private Date deadline;
    private int progressPercentage;

    private ArrayList<User>  assignedUsers = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>();





    public Task(int id, String title, String description, Date dateAndTimeOfCreation, Date dateAndTimeOfDeadline, ArrayList<User> assignedUsers, ArrayList<String> comments) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.assignedUsers = assignedUsers;
        this.comments = comments;
        this.progressPercentage = 0;
    }

    public Task (Date dateAndTimeOfDeadline) {
        this.deadline = dateAndTimeOfDeadline;
    }
    public int getProgressPercentage(){return progressPercentage;}

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
    public void updateTitle(String newTitle){
        this.title = newTitle;
    }

    public void updateDescription(String newDescription){
        this.title = newDescription;
    }

    public void updatePriority(String newPriority){
        if (newPriority.equals("Highest")){
            this.priority = TaskPriority.Highest;
        }
        else if (newPriority.equals("High")){
            this.priority = TaskPriority.High;
        }
        else if (newPriority.equals("Low")){
            this.priority = TaskPriority.Low;
        }
        else if (newPriority.equals("Lowest")){
            this.priority = TaskPriority.Lowest;
        }
    }

    public void updateDeadline(int year, int month, int day, int hour, int minute){
        this.deadline = new Date(year, month, day, hour, minute);
    }

    public void removeUser(String username){
        this.assignedUsers.remove(User.getUserWithUserName(username));
    }

    public void addUser(String username){
        if (User.getUserWithUserName(username) != null){
            this.assignedUsers.add(User.getUserWithUserName(username));
        }
        else System.out.println("There is not any user with this username" + username + "in list! ");
    }

}
