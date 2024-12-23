package template;


public class FoodDataParseStrategy implements ParserStrategy{

    @Override
    public FoodData parse(String line) {
        FoodData foodData = new FoodData("asdf", 0.1, 0.1); //foodData 초기화
        String[] values = line.split(",");

        foodData.setName(values[0]);
        foodData.setCarbs(Double.parseDouble(values[1]));
        foodData.setCalories(Double.parseDouble(values[2]));

        return foodData;
        // TODO Auto-generated method stub
    }

}
