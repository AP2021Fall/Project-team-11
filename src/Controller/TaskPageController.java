package Controller;

import Model.Task;
import Model.User;

public class TaskPageController {
    private User theUser;
    private Task theTask;




    public void setTheUser(User theUser) {
        this.theUser = theUser;
    }

    public void setTheTask(Task theTask) {
        this.theTask = theTask;
    }

}
