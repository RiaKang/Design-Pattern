//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

package Arthropod;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        //arthropod.csv 파일을 읽어와 classifier의 리스트 classifiers 생성, 해당 리스트를 토대로 분류할 classification 생성
        List<ArthropodClassifier> classifiers = ArthropodImporter.loadCSV("arthropods.csv");
        ArthropodClassification classification = new ArthropodClassification(classifiers);

        //beetle Arthropod 생성
        Arthropod beetle = new Arthropod.ArthropodBuilder().bodyRegions(3).pairsOfAntennae(1).
        respiration(RespirationType.TRACHEAL).metamorphosis(MetamorphosisType.COMPLETE).pairsOfWings(2).
        numberOfLegs(6).distinction("hard exoskeleton and elytra (wing covers)").build();
        
        //beetle 분류
        System.out.println("beetle 분류");
        System.out.println(beetle);
        System.out.println(" => Arthropod Type: " + classification.classify(beetle));

        //crab 분류
        Arthropod crab = ArthropodFactory.create(ArthropodType.CRUSTACEA);
        System.out.println("crab 분류");
        System.out.println(crab);
        System.out.println(" => Arthropod Type: " + classification.classify(crab));
        
        //다른 Arthropod 생성 ODONATA,3,1,TRACHEAL,INCOMPLETE,2,6,wings membranous
        Arthropod arthropodToClassify = new Arthropod.ArthropodBuilder().bodyRegions(3).pairsOfAntennae(1).
        respiration(RespirationType.TRACHEAL).metamorphosis(MetamorphosisType.INCOMPLETE).pairsOfWings(2).
        numberOfLegs(6).distinction("wings membranous").build();

        System.out.println("arthropodToClassify 분류");
        Optional<ArthropodClassifier> matchingClassifier = classifiers.stream().
        filter(classifier -> classifier.matches(arthropodToClassify)).findFirst();
        //전체 전체 classifier에서 arthropodToClassify와 matches되는, 동일한 것이 있다면
        if(matchingClassifier != null)
            System.out.println(matchingClassifier); //arthropodToClassify와 동일한 내용 출력하기
        System.out.println();
        System.out.println();

        //classifier에 있는 내용 분류
        List<Arthropod> arthropods = classifiers.stream().map(classifier -> classifier.getArthropod()).collect(Collectors.toList());
        System.out.println("전체 Classifier 분류");
        for(Arthropod arthropod : arthropods){
            System.out.println(arthropod);
            System.out.println(" => Arthropod Type: " + classification.classify(arthropod));
        }

        //Unknown Arthropod 생성, 일부러 classifier에 없는 이상값 넣어주기
        Arthropod unknown = new Arthropod.ArthropodBuilder().bodyRegions(0).pairsOfAntennae(0).
        respiration(RespirationType.TRACHEAL).metamorphosis(MetamorphosisType.COMPLETE).pairsOfWings(0).
        numberOfLegs(0).distinction("UNKNOWN DISTINCTION").build();
        
        //Unknown 분류
        System.out.println("Unknown 분류");
        System.out.println(unknown);
        System.out.println(" => Arthropod Type: " + classification.classify(unknown));

        System.out.println();
        System.out.println();

        //YourCode
        System.out.println("\nComparing");
        int i = 0;
        for(Arthropod arthropod : arthropods){ //위에서 사용한 전체 arthropod에 대하여
            ArthropodComparison arthropodComparison = new ArthropodComparison(); //비교하기 위한 Comparision 생성
            String difference = arthropodComparison.arthropodCompare(beetle, arthropod); //전체 arthropod과 beetle을 비교
            System.out.println("Beetle Vs. " + ArthropodType.values()[i] + "\n" + difference); //beetle과의 차이점 출력
            i++;
        }
    }
}