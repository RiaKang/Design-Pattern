package template;

public class DailyHealthDataParseStrategy implements ParserStrategy{

    @Override
    public DailyHealthData parse(String line) {
        //dailyHealthData 생성으로 초기화
        DailyHealthData dailyHealthData = new DailyHealthData("2000", 0, 0, 0);

        String[] values = line.split(",");

        dailyHealthData.setDate(values[0]);
        dailyHealthData.setBloodSugarLevel(Double.parseDouble(values[1]));
        dailyHealthData.setInsulinDose(Double.parseDouble(values[2]));
        dailyHealthData.setCarbsIntake(Double.parseDouble(values[3]));
        
        return dailyHealthData;
        // TODO Auto-generated method stub\
    }

}
