package Controller;
import Model.Date;
import Model.Task;
import Model.User;

import java.util.ArrayList;
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
        return formattedDeadlines;
    }

    private static String formatDeadline(Date date){
        String deadline = date.getYear() + "-" + date.getMonth() + "-" + date.getDay() + "__remaining days: ";
        String timeDifferenceBetweenNowAndDeadline = date.timeDifferenceWithLive(date);
        Pattern timePattern = Pattern.compile("^([0-9]{1,3})-([0-9]{1,2})-([0-9]{1,2})$");
        Matcher timeMatcher = timePattern.matcher(timeDifferenceBetweenNowAndDeadline);
        int yearDifference = Integer.parseInt(timeMatcher.group(1));
        int monthDifference = Integer.parseInt(timeMatcher.group(2));
        int dateDifference = Integer.parseInt(timeMatcher.group(3));
        int remainingDays = (yearDifference*360) + (monthDifference*30) + dateDifference;
        if (yearDifference > 0 || monthDifference > 0 || dateDifference > 10){
            return "*" + deadline + remainingDays;
        }
        else if(dateDifference >=4){
            return "**" + deadline + remainingDays;
        }
        else {
            return "***" + deadline + remainingDays;
        }
    }
}
