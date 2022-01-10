package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {
    final int year;
    final int month;
    final int day;
    final int hour;
    final int minute;

    public int getYear(){ return this.year;}

    public int getMonth(){ return this.month;}

    public int getDay(){ return this.day;}

    public int getHour(){ return this.hour;}

    public int getMinute(){ return this.minute;}

    public static String liveTime(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter livedate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String liveTimeStr = livedate.format(time);
        return liveTimeStr;

    }

    public static String timeDifferenceWithLive (Date date){
        String liveTimeStr = liveTime();
        int liveYear = liveTimeStr.charAt(0) + liveTimeStr.charAt(1) + liveTimeStr.charAt(2) + liveTimeStr.charAt(3) ;
        int yearDifference = liveYear - date.year ;
        int liveMonth = liveTimeStr.charAt(5) + liveTimeStr.charAt(6);
        int monthDifference = liveMonth - date.month;
        int liveDate = liveTimeStr.charAt(8) + liveTimeStr.charAt(9);
        int dayDifference = liveDate - date.day;
        if(dayDifference < 0) {
            dayDifference += 30;
            monthDifference -= 1;
        }
        if (monthDifference < 0) {
            monthDifference += 12;
            yearDifference -= 1;
        }
        return String.valueOf(yearDifference) + "-" + String.valueOf(monthDifference) + "-" + String.valueOf(dayDifference);
    }


    public Date(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
}
