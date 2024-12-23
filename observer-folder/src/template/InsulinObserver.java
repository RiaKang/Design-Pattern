package template;

public class InsulinObserver implements Observer{
    double insulinThreshold;
    public InsulinObserver(double insulinThreshold){
        this.insulinThreshold = insulinThreshold;
    }

    @Override
    public void update(DailyHealthData d) {
        if (d.getInsulinDose()> insulinThreshold){
            System.out.println("Date :" + d.getDate() + " InsulineDose : " + d.getInsulinDose());
            System.out.println("InsulinDose Alert!!!!");
        }
        // TODO Auto-generated method stub
    }

}
