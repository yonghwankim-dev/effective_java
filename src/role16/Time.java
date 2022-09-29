package role16;

// publid 클래스의 필드가 불변(final)이라면 노출시 단점은 줄어들지만 좋은 생각은 아님
public class Time {
    private static final int HOURS_PER_DAY    = 24;
    private static final int MINUTES_PER_HOUR = 60;

    public final int hour;
    public final int minute;

    public Time(int hour, int minute) {
        if(hour < 0 || hour >= HOURS_PER_DAY){
            throw new IllegalStateException("시간 : " + hour);
        }
        if(minute < 0 || minute >= MINUTES_PER_HOUR){
            throw new IllegalStateException("분 : " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
}
