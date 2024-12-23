//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

package Arthropod;

import java.util.List;

public class ArthropodFactory { //Factory 패턴
    public static Arthropod create(ArthropodType type){ //Arthropod 객체를 생성하여 return하는 create 메소드
                                                        //ArthropodType을 받아서, 해당하는 Type의 Arthropod을 return한다.
        Arthropod arthropod = null;
        List<ArthropodClassifier> classifiers = ArthropodImporter.loadCSV("arthropods.csv");
        for(ArthropodClassifier classifier : classifiers){ //arthropod.csv파일에 기준하여 해당하는 classifier을 찾는다.
            if(classifier.getArthropodType() == type){      //입력받은 Type에 대한 정보를 찾으면, 해당 정보들을 입력하여 Arthropod 생성
                arthropod = new Arthropod.ArthropodBuilder(). //builder패턴으로 구현한 ArthropodBuilder를 통해 생성
                bodyRegions(classifier.getArthropod().getBodyRegions()).
                pairsOfAntennae(classifier.getArthropod().getPairsOfAntennae()).
                respiration(classifier.getArthropod().getRespiration()).
                metamorphosis(classifier.getArthropod().getMetamorphosis()).
                pairsOfWings(classifier.getArthropod().getPairsOfWings()).
                numberOfLegs(classifier.getArthropod().getNumberOfLegs()).
                distinction(classifier.getArthropod().getDistinction()).
                build();      
                return arthropod;         
            }
        }
        return arthropod;
    }

    public Arthropod create(int bodyRegions, int pairsOfAntennae, RespirationType respiration, MetamorphosisType metamorphosis, 
                            int pairsOfWings, int numberOfLegs, String distinction){
        //위의 create는 ArthropodType을 입력받으면, 해당하는 정보를 찾아 객체 생성
        //이 create는 정보를 입력받아서, 정보들로 객체 생성
        Arthropod arthropod = new Arthropod.ArthropodBuilder().
                                bodyRegions(bodyRegions).
                                pairsOfAntennae(pairsOfAntennae).
                                respiration(respiration).
                                metamorphosis(metamorphosis).
                                pairsOfWings(pairsOfWings).
                                numberOfLegs(numberOfLegs).
                                distinction(distinction).
                                build();

        return arthropod;
    }
}
