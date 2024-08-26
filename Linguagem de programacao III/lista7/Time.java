import java.time.LocalTime;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) 
    {
        if(validateTime(hour, minute, second))
        {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        else
        {
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
        }
    }

    private boolean validateTime(int hora, int min, int seg)
    {
        return validateHour(hora) && 
               validateMinOrSec(min) && 
               validateMinOrSec(seg);
    }

    private boolean validateHour(int hora)
    {
        if((hora>=0) && (hora<25))
            return true;
        else
            return false;
    }

    private boolean validateMinOrSec(int param)
    {
        if((param>=0) && (param<61))
            return true;
        else
            return false;
    }

    //get hora
    public int getHour()
    {
        return this.hour;
    }

    //get min
    public int getMinute()
    {
        return this.minute;
    }

    //get seconds
    public int getSecond()
    {
        return this.second;
    }

    public static Time diffTime(Time t1, Time t2)
    {
        int diffHour = Math.abs(t1.getHour() - t2.getHour());
        int diffMinute = Math.abs(t1.getMinute() - t2.getMinute());
        int diffSecond = Math.abs(t1.getSecond() - t2.getSecond());
        return new Time(diffHour, diffMinute, diffSecond);
    }

    public static Time diffTime(Time t) 
    {
        LocalTime currentTime = LocalTime.now();
        int diffHour = Math.abs(t.getHour() - currentTime.getHour());
        int diffMinute = Math.abs(t.getMinute() - currentTime.getMinute());
        int diffSecond = Math.abs(t.getSecond() - currentTime.getSecond());
        return new Time(diffHour, diffMinute, diffSecond);
    }

    public static boolean isAm(Time t) 
    {
        return t.getHour() < 12;
    }

    public static boolean isPm(Time t) 
    {
        return t.getHour() >= 12;
    }
}
