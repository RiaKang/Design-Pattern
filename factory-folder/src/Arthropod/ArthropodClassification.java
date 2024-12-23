//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

package Arthropod;

import java.util.List;

public class ArthropodClassification {
    private List<ArthropodClassifier> classifiers; //classifier의 리스트 clasifiers
    
    public ArthropodClassification(List<ArthropodClassifier> classifiers){
        this.classifiers = classifiers; //분류 리스트를 입력받아 사용
    }

    public ArthropodType classify(Arthropod arthropod){ //classifiers의 내용들을 토대로 동일한 것이 있다면 return
        for(ArthropodClassifier classifier : classifiers){
            if(classifier.matches(arthropod)){ //classifiers에 인자인 arthropod과 동일한 내용이 있다면
                return classifier.getArthropodType(); //해당 분류의 Type을 return하여 확인할 수 있도록 한다
            }
        }
        return ArthropodType.UNKNOWN; //classifiers 내에 동일한 내용이 없다면 UNKNOWN으로 간주, return
    }

    public ArthropodType classify(int bodyRegions, int pairsOfAntennae, RespirationType respiration, 
                                MetamorphosisType metamorphosis, int pairsOfWings, int numberOfLegs, String distinction){
        //위의 classify와 입력받는 인자가 달라진다.
        for(ArthropodClassifier classifier : classifiers){ //전체 classifiers에 대해서
            if(classifier.matches(bodyRegions, pairsOfAntennae, respiration, metamorphosis, 
                                    pairsOfWings, numberOfLegs, distinction)){
                //입력받은 인자의 정보와 동일한 내용이 classifiers에 있다면
                return classifier.getArthropodType(); //해당하는 ArthropodType을 반환하여 분류하도록 한다.
            }
        }
        return ArthropodType.UNKNOWN; //해당 정보와 일치하는 내용이 없을 경우 분류 실패, UNKNOWN return
    }
}
