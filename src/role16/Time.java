package role16;

// publid Ŭ������ �ʵ尡 �Һ�(final)�̶�� ����� ������ �پ������ ���� ������ �ƴ�
public class Time {
    private static final int HOURS_PER_DAY    = 24;
    private static final int MINUTES_PER_HOUR = 60;

    public final int hour;
    public final int minute;

    public Time(int hour, int minute) {
        if(hour < 0 || hour >= HOURS_PER_DAY){
            throw new IllegalStateException("�ð� : " + hour);
        }
        if(minute < 0 || minute >= MINUTES_PER_HOUR){
            throw new IllegalStateException("�� : " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
}
