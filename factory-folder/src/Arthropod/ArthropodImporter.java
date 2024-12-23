//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

package Arthropod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArthropodImporter {
    public static List<ArthropodClassifier> loadCSV(String filename){ //CSV파일 load
        //변수 선언
        List<ArthropodClassifier> data = new ArrayList<>();
        ArthropodType type;
        int bodyRegions;
        int pairsOfAntennae;
        RespirationType respiration;
        MetamorphosisType metamorphosis;
        int pairsOfWings;
        int numberOfLegs;
        String distinction;
        ArthropodFactory factory = new ArthropodFactory();
        Arthropod arthropod;

        String line; //CSV파일을 한 줄 씩 읽어올 line 변수
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            line = br.readLine(); //첫 줄 건너뛰기
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // , 를 기준으로 분리
                if(ArthropodType.valueOf(values[0]) != ArthropodType.UNKNOWN){ //한 줄에는 ArthropodType~Distinction까지 총 8개의 정보가 존재
                    type = ArthropodType.valueOf(values[0]); //0번부터 순차적으로 해당하는 변수에 입력
                    bodyRegions = Integer.parseInt(values[1]);
                    pairsOfAntennae = Integer.parseInt(values[2]);
                    respiration = RespirationType.valueOf(values[3]); //각 변수 타입별로 변환하여 입력하기
                    metamorphosis = MetamorphosisType.valueOf(values[4]);
                    pairsOfWings = Integer.parseInt(values[5]);
                    numberOfLegs = Integer.parseInt(values[6]);
                    distinction = values[7];

                    arthropod = factory.create(bodyRegions, pairsOfAntennae, respiration, metamorphosis, //create 메소드를 통해 읽어온 정보를
                                            pairsOfWings, numberOfLegs, distinction);                   // 사용하여 arthropod 생성
                    ArthropodClassifier classifier = new ArthropodClassifier(type, arthropod); 
                    //읽어온 Type과 변수들을 사용해 생성한 Arthropod을 사용하여 classifier 생성
                    data.add(classifier); //classifier 리스트인 data에 한 줄을 읽어 생성한 classifier 추가
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return data; //CSV파일을 모두 읽고 생성된 classifier의 리스트 반환 = 전체 classifier 리스트
    }
}
