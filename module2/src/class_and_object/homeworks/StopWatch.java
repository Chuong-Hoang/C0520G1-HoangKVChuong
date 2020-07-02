package class_and_object.homeworks;
import java.util.Date;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch(){
        Date d = new Date();
        this.startTime = d.getTime();
    }
    public void start(){
        Date d = new Date();
        this.startTime = d.getTime();
    }
    public void stop(){
        Date d = new Date();
        this.endTime = d.getTime();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }
    public long getElapsedTime(){
        return this.getEndTime() - this.getStartTime();
    }
}
