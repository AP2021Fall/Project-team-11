package Controller;
import Model.Date;
import Model.Task;
import Model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CalenderMenuController {
    public ArrayList<String> getFormattedDeadlines (){
        ArrayList<Task>  userTasks= User.getLoggedInUser().getTasks() ;
        ArrayList<String> formattedDeadlines = new ArrayList<String>();
        for (Task task: userTasks) {
                formattedDeadlines.add(formatDeadline(task.getDeadline()));
        }
        /// maybe reverse !!
        Collections.sort(formattedDeadlines);
        return formattedDeadlines;
    }

    private static String formatDeadline(Date date){
        String deadline = date.getYear() + "-" + date.getMonth() + "-" + date.getDay() + "__remaining days: ";
        String timeDifferenceBetweenNowAndDeadline = date.timeDifferenceWithLive(date);
        String[] split = timeDifferenceBetweenNowAndDeadline.split("/");
        int yearDifference = Integer.parseInt(split[0]);
        int monthDifference = Integer.parseInt(split[1]);
        int dateDifference = Integer.parseInt(split[2]);
        int remainingDays = (yearDifference*360) + (monthDifference*30) + dateDifference;
        if (remainingDays >= 10){
            return "*" + deadline + remainingDays;
        }
        else if(remainingDays >=4){
            return "**" + deadline + remainingDays;
        }
        else if(remainingDays >= 0){
            return "***" + deadline + remainingDays;
        }
        else
            return null;
    }
}
