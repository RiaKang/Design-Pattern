package template;

public class CarbsIntakeObserver implements Observer{
    double carbsIntakeThreshold;
    public CarbsIntakeObserver(double carbsIntakeThreshold){
        this.carbsIntakeThreshold = carbsIntakeThreshold;
    }

    @Override
    public void update(DailyHealthData d) {
        if (d.getCarbsIntake()> carbsIntakeThreshold){
            System.out.println("Date :" + d.getDate() + " CarbsIntake : " + d.getCarbsIntake());
            System.out.println("CarbsIntake Alert!!!!");
        }
        // TODO Auto-generated method stub
    }

}
