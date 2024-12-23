package template;

import java.util.List;

public class MainTest {

    public MainTest() {
        // Load fooddata
		List<FoodData> foodDataList = new FileImporter<>(new FoodDataParseStrategy()).loadCSV("fooddata.csv");
        System.out.println("FoodDataParse");
        // Load dailyfooddata
		List<DailyFoodData> dailyFoodDataList = new FileImporter<>(new DailyFoodDataParseStrategy(foodDataList)).loadCSV("dailyfooddata.csv");
        System.out.println("DailyFoodDataParse");
        // Load dailyhealthdata
		List<DailyHealthData> dailyHealthDataList = new FileImporter<>(new DailyHealthDataParseStrategy()).loadCSV("dailyhealthdata.csv");
        System.out.println("DailyHealthDataParse");

        // Subject
        DiabetesManager manager = new DiabetesManager();
        // Observer
        BloodSugarObserver bloodSugarObserver = new BloodSugarObserver(150);
        CarbsIntakeObserver carbsIntakeObserver = new CarbsIntakeObserver(100);
        InsulinObserver insulinObserver = new InsulinObserver(10);
        MedicineObserver medicineObserver = new MedicineObserver(150, 100, 10);
        // Add observers
        manager.addObserver(bloodSugarObserver);
        manager.addObserver(carbsIntakeObserver);
        manager.addObserver(insulinObserver);
        manager.addObserver(medicineObserver);
        
        // Remove observers test
        // 옵저버 추가-삭제 루틴 (사용 시 주석만 제거)
        // manager.removeObserver(insulinObserver);
        // manager.removeObserver(carbsIntakeObserver);
        // manager.addObserver(insulinObserver);
        // manager.addObserver(carbsIntakeObserver);

        // Simulate health data updates with food integration
        new Thread(() -> {
            for (DailyHealthData h : dailyHealthDataList) {
                DailyFoodData f = dailyFoodDataList.stream().filter(e -> e.getDate().equals(h.getDate())).findAny().orElse(null);
                double totalCarbs = f.getFoods().stream().mapToDouble(e -> e.getCarbs()).sum();
                totalCarbs += h.getCarbsIntake();
                h.setCarbsIntake(totalCarbs);
                double insulinDose = (h.getInsulinDose() + totalCarbs) / 10.0;
                h.setInsulinDose(insulinDose);
                manager.addDailyHealthData(h);
                try {
                    Thread.sleep(1000); // Wait for 1 second before the next update
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\n\n\n");
            }
        }).start();
    }
}
