package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date implements Comparable{
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
        return livedate.format(time);

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
        return yearDifference + "-" + monthDifference + "-" + dayDifference;
    }


    public Date(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int compareTo(Object o) {
        Date date2 = (Date)o;
        int thisTime = this.year*365*24*60 + this.month*30*24*60 + this.day*24*60 + this.hour*60 + this.minute;
        int thatTime = date2.year*365*24*60 + date2.month*30*24*60 + date2.day*24*60 + date2.hour*60 + date2.minute;
        return thisTime-thatTime;
    }

    public Date(String date){
        String[] dateSplit1 = date.split("\\|")[0].split("-");
        String[] dateSplit2 = date.split("\\|")[1].split(":");
        this.year = Integer.parseInt(dateSplit1[0]);
        this.month = Integer.parseInt(dateSplit1[1]);
        this.day = Integer.parseInt(dateSplit1[2]);
        this.hour = Integer.parseInt(dateSplit2[0]);
        this.minute = Integer.parseInt(dateSplit2[1]);
    }

    @Override
    public String toString() {
        return year+"-"+month +"-" + day;
    }
}
