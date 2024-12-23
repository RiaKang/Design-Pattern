package template;
import java.util.ArrayList;
import java.util.List;

public class DiabetesManager implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private DailyHealthData d;

    public DiabetesManager(){

    }

    public void addDailyHealthData(DailyHealthData d){
        this.d = d;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(d));
        // TODO Auto-generated method stub
    }
}
