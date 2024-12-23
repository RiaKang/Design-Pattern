package template;

public class DiskScheduler{
    SeekStrategy strategy;

    public void setSeekStrategy(SeekStrategy strategy){
        this.strategy = strategy;
    }

    public void executeSeek(int[] queue, int start){
        strategy.seek(queue, start);
    }
}
