//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

//YourCode
package Arthropod;

import java.util.Objects;

public class ArthropodComparison { //Arthropod 객체들을 비교하는 메소드

    public String arthropodCompare(Arthropod arthropod1, Arthropod arthropod2){ //비교할 두 객체를 인자로 받는다
        String difference = ""; //최초 차이점은 없음.
        if(arthropod1.getBodyRegions() != arthropod2.getBodyRegions()) //Arthropod이 가지는 속성 변수들을 비교
            difference += "BodyRegions, ";                              //다른 내용이 있을 경우, 해당하는 내용을 difference에 추가
        if(arthropod1.getPairsOfAntennae() != arthropod2.getPairsOfAntennae())
            difference += "PairsOfantennae, ";
        if(arthropod1.getRespiration() != arthropod2.getRespiration())
            difference += "Respiration, ";
        if(arthropod1.getMetamorphosis() != arthropod2.getMetamorphosis())
            difference += "Metamorphosis, ";
        if(arthropod1.getPairsOfWings() != arthropod2.getPairsOfWings())
            difference += "PairOfWings, ";
        if(arthropod1.getNumberOfLegs() != arthropod2.getNumberOfLegs())
            difference += "PairsOfantennae, ";
        if(!Objects.equals(arthropod1.getDistinction(), arthropod2.getDistinction()))
            difference += "Distinction";
        if(Objects.equals(difference, "")) //차이점이 아무것도 없을 경우
            difference += "Nothing"; //difference에 Nothing 추가
        return "Differences between two Arthropods are : " + difference; //최종 차이점을 출력할 수 있도록 return
    }
}
