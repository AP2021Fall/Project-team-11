package Controller;
import Model.Leader;
import Model.Task;
import Model.User;
import java.util.regex.Matcher;
import static Main.Main.*;

public class TaskPageController {
    private Task theTask;
    private final String EDIT_TITLE_PATTERN = "edit --task --id (\\w+) --title (\\w+)";
    private final String EDIT_DESCRIPTION_PATTERN = "edit --task --id (\\w+) --descriptions (\\w+)";
    private final String EDIT_PRIORITY_PATTERN = "edit --task --id (\\w+) --Priority (Highest || High || Low || Lowest)";
    private final String EDIT_DEADLINE_PATTERN = "edit --task --id (\\w+) --Deadline (\\d{4})-(\\d{2})-(\\d{2})|(\\d{2}):(\\d{2})";
    private final String ASSIGNED_USERS_REMOVE_PATTERN = "edit --task --id (\\w+) --assignedUsers (\\w+) --remove";
    private final String ASSIGNED_USERS_ADD_PATTERN = "edit --task --id (\\w+) --assignedUsers (\\w+) --add";
    private final String HELP_PATTERN = "help";
    private final String BACK_PATTERN = "back";
    private final String INVALID_COMMAND_PROMPT = "invalid command!";
    private static TaskPageController controller = new TaskPageController();
    private String command;

    public static TaskPageController getController() {
        return controller;
    }

    public void runMenu(){
        help();
        while (true){
            command = getScanner().nextLine();
            if (User.getLoggedInUser() instanceof Leader){
                if (command.matches(BACK_PATTERN)){
                    return;
                }
                else if (command.matches(HELP_PATTERN)){
                    help();
                }
                else if (command.matches(EDIT_TITLE_PATTERN)){
                    taskPageWithID(getMatcher(command, EDIT_TITLE_PATTERN));
                    theTask.updateTitle(newFeature(getMatcher(command, EDIT_TITLE_PATTERN)));
                    System.out.println("Title updated successfully!");
                }
                else if (command.matches(EDIT_DESCRIPTION_PATTERN)){
                    taskPageWithID(getMatcher(command, EDIT_DESCRIPTION_PATTERN));
                    theTask.updateDescription(newFeature(getMatcher(command, EDIT_DESCRIPTION_PATTERN)));
                    System.out.println("Description updated successfully!");
                }
                else if (command.matches(EDIT_PRIORITY_PATTERN)){
                    taskPageWithID(getMatcher(command, EDIT_PRIORITY_PATTERN));
                    theTask.updatePriority(newFeature(getMatcher(command, EDIT_PRIORITY_PATTERN)));
                    System.out.println("Priority updated successfully!");
                }
                else if (command.matches(EDIT_DEADLINE_PATTERN)){
                    taskPageWithID(getMatcher(command, EDIT_DEADLINE_PATTERN));
                    theTask.updateDeadline(newYear(getMatcher(command, EDIT_DEADLINE_PATTERN)),
                            newMonth(getMatcher(command, EDIT_DEADLINE_PATTERN)),
                            newDay(getMatcher(command, EDIT_DEADLINE_PATTERN)),
                            newHour(getMatcher(command, EDIT_DEADLINE_PATTERN)),
                            newMinute(getMatcher(command, EDIT_DEADLINE_PATTERN)));
                    System.out.println("Deadline updated successfully!");
                }
                else if (command.matches(ASSIGNED_USERS_ADD_PATTERN)){
                    taskPageWithID(getMatcher(command, ASSIGNED_USERS_ADD_PATTERN));
                    theTask.addUser(getUsername(getMatcher(command, ASSIGNED_USERS_ADD_PATTERN)));
                    System.out.println("User"+ getUsername(getMatcher(command, ASSIGNED_USERS_ADD_PATTERN))+"added successfully!");
                }
                else if (command.matches(ASSIGNED_USERS_REMOVE_PATTERN)){
                    taskPageWithID(getMatcher(command, ASSIGNED_USERS_REMOVE_PATTERN));
                    theTask.removeUser(getUsername(getMatcher(command, ASSIGNED_USERS_REMOVE_PATTERN)));
                    System.out.println("User"+ getUsername(getMatcher(command, ASSIGNED_USERS_REMOVE_PATTERN))+"removed successfully!");
                }
                else System.out.println(INVALID_COMMAND_PROMPT);
            }
            else System.out.println("You Don’t Have Access To Do This Action!");
        }
    }


    public String getUsername(Matcher matcher) {
        matcher.find();
        return matcher.group(2);
    }



    private void taskPageWithID(Matcher matcher) {
        matcher.find();
        int id = Integer.parseInt(matcher.group(1));
        theTask = Task.getTaskById(id);
    }

    private String newFeature(Matcher matcher){
        matcher.find();
        return matcher.group(2);
    }

    private void help(){
        System.out.println("edit --task --id <taskId> --title <newTitle>\n");
    }

    private int newYear(Matcher matcher){
        matcher.find();
        return Integer.parseInt(matcher.group(2));
    }
    private int newMonth(Matcher matcher){
        matcher.find();
        return Integer.parseInt(matcher.group(3));
    }
    private int newDay(Matcher matcher){
        matcher.find();
        return Integer.parseInt(matcher.group(4));
    }
    private int newHour(Matcher matcher){
        matcher.find();
        return Integer.parseInt(matcher.group(5));
    }
    private int newMinute(Matcher matcher){
        matcher.find();
        return Integer.parseInt(matcher.group(6));
    }

}