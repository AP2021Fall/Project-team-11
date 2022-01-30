package Model;


import java.util.ArrayList;

public class Task implements Comparable{
    private static ArrayList<Task> allTasks = new ArrayList<>();
    private int id;
    private String title;
    private String description;
    private TaskPriority priority;
    private Date startTime;
    private Date deadline;
    private int progressPercentage = 0;
    private ArrayList<User>  assignedUsers = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>();
    private Team taskTeam;
    private static int lastId;
    private Board board;
    public boolean checkFailure = false;



    @Override
    public int compareTo(Object o) {
        if(this.startTime.compareTo(((Task)o).startTime) != 0)
            return this.startTime.compareTo(((Task)o).startTime);
        return this.priority.compareTo(((Task)o).priority);
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

    public int getProgressPercentage(){
        return progressPercentage;
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
        if(priority == TaskPriority.Highest);
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

    public void addMember(Member member){
        assignedUsers.add(member);
    }

    public void removeMember(Member member){
        assignedUsers.remove(member);
    }

    public Team getTaskTeam() {
        return taskTeam;
    }

    public void changeProggressPercentage(int percentage){this.progressPercentage = percentage;}

}
