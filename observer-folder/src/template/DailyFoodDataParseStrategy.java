package template;
import java.util.ArrayList;
import java.util.List;

public class DailyFoodDataParseStrategy implements ParserStrategy{
    private List<FoodData> foodDataList;

    public DailyFoodDataParseStrategy(List<FoodData> foodDataList){
        this.foodDataList = foodDataList;
    }

    @Override
    public DailyFoodData parse(String line) {
        DailyFoodData dailyFoodData = new DailyFoodData("2000-01-01", foodDataList); // dailyFoodData 초기화
        String replaceLine = line.replace("\"", "");
        String[] values = replaceLine.split(",");

        dailyFoodData.setDate(values[0]); // , 기준 앞의 날짜를 setDate

        List<FoodData> foodForDaily = new ArrayList<>(); //하루치 식사 => "" 사이의 음식 리스트
        for (int i = 1; i < values.length; i++){
            for (FoodData f : foodDataList){
                if (values[i].equals(f.getName())){
                    foodForDaily.add(f);
                }
            }
        }
        dailyFoodData.setFoods(foodForDaily); //dailyfooddata.csv에 있는 String 형식의 음식 이름을 통해 FoodData에서 가져옴

        return dailyFoodData;
        // TODO Auto-generated method stub
    }

}
