//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

package Arthropod;

import java.util.Objects;

public class ArthropodClassifier {
    private ArthropodType arthropodType; //분류될 ArthropodType
    private Arthropod arthropod; //해당하는 Arthropod

    public ArthropodClassifier(ArthropodType arthropodType, Arthropod arthropod){
        this.arthropodType = arthropodType;
        this.arthropod = arthropod;
    }

    public boolean matches(Arthropod arthropod){ //인자의 arthropod과 classifier의 arthropod 비교
        return (getArthropod().equals(arthropod));
    }

    public boolean matches(int bodyRegions, int pairsOfAntennae, RespirationType respiration, 
    MetamorphosisType metamorphosis, int pairsOfWings, int numberOfLegs, String distinction){
        //arthropod객체 대신, 해당 arthropod이 가지는 정보들을 입력받는 경우
        //전체 정보를 비교, 모두 동일할 경우 true, 하나라도 다르면 false return
        return ((getArthropod().getBodyRegions() == bodyRegions)
        && (getArthropod().getPairsOfAntennae() == pairsOfAntennae)
        && (getArthropod().getRespiration() == respiration)
        && (getArthropod().getMetamorphosis() == metamorphosis)
        && (getArthropod().getPairsOfWings() == pairsOfWings)
        && (getArthropod().getNumberOfLegs() == numberOfLegs)
        && Objects.equals(getArthropod().getDistinction(), distinction));
    }
    
    public ArthropodType getArthropodType(){ //get 메소드
        return arthropodType;
    }

    public Arthropod getArthropod(){
        return arthropod;
    }

    public String toString(){ // 출력을 위한 toString 메소드
        return getArthropod().toString() + "\n => Arthropod Type: " + getArthropodType().toString();
    }
}
