package template;

public class BloodSugarObserver implements Observer{
    double bloodSugarThreshold;
    public BloodSugarObserver(double bloodSugarThreshold){
        this.bloodSugarThreshold = bloodSugarThreshold;
    }

    @Override
    public void update(DailyHealthData d) {
        if (d.getBloodSugarLevel()> bloodSugarThreshold){
            System.out.println("Date :" + d.getDate() + " BloodSugarLevel : " + d.getBloodSugarLevel());
            System.out.println("BloodSugar Alert!!!!");
        }
        // TODO Auto-generated method stub
    }

}
