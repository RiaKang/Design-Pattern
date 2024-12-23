package template;

public class MedicineObserver implements Observer{
    double bloodSugarThreshold;
    double carbsIntakeThreshold;
    double insulinThreshold;

    public MedicineObserver(double bloodSugarThreshold, double carbsIntakeThreshold, double insulinThreshold){
        this.bloodSugarThreshold = bloodSugarThreshold;
        this.carbsIntakeThreshold = carbsIntakeThreshold;
        this.insulinThreshold = insulinThreshold;
    }

    @Override
    public void update(DailyHealthData d) {
        if (d.getBloodSugarLevel() > bloodSugarThreshold && d.getCarbsIntake() > carbsIntakeThreshold 
        && d.getInsulinDose() > insulinThreshold) {
            System.out.println("Medicine : Repaglinide");
        } else if (d.getBloodSugarLevel() > bloodSugarThreshold && d.getCarbsIntake() > carbsIntakeThreshold) {
            System.out.println("Medicine : Chlorpropamide.");
        } else if (d.getBloodSugarLevel() > bloodSugarThreshold && d.getInsulinDose() > insulinThreshold) {
            System.out.println("Medicine : Glibenclamide");
        } else if (d.getCarbsIntake() > carbsIntakeThreshold && d.getInsulinDose() > insulinThreshold) {
            System.out.println("Medicine : Glucagon-1");
        } else if (d.getBloodSugarLevel() > bloodSugarThreshold) {
            System.out.println("Medicine : Sulfonylureas");
        } else if (d.getCarbsIntake() > carbsIntakeThreshold) {
            System.out.println("Medicine : Acarboze");
        } else if (d.getInsulinDose() > insulinThreshold) {
            System.out.println("Medicine : Dapazin Tab");
        }
        // TODO Auto-generated method stub
    }

}
