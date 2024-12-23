//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

package Arthropod;
import java.util.Objects;

public class Arthropod {
    //Arthropod이 가질 속성 변수
    private final int bodyRegions;
    private final int pairsOfAntennae;
    private final RespirationType respiration;
    private final MetamorphosisType metamorphosis;
    private final int pairsOfWings;
    private final int numberOfLegs;
    private final String distinction;

    private Arthropod(ArthropodBuilder builder){ //builder를 사용하여 값 입력
        this.bodyRegions = builder.bodyRegions;
        this.pairsOfAntennae = builder.pairsOfAntennae;
        this.respiration = builder.respiration;
        this.metamorphosis = builder.metamorphosis;
        this.pairsOfWings = builder.pairsOfWings;
        this.numberOfLegs = builder.numberOfLegs;
        this.distinction = builder.distinction;
    }

    public int getBodyRegions(){ //각 변수들이 get메소드 선언 부분
        return bodyRegions;
    }

    public int getPairsOfAntennae(){
        return pairsOfAntennae;
    }

    public RespirationType getRespiration(){
        return respiration;
    }

    public MetamorphosisType getMetamorphosis(){
        return metamorphosis;
    }

    public int getPairsOfWings(){
        return pairsOfWings;
    }

    public int getNumberOfLegs(){
        return numberOfLegs;
    }

    public String getDistinction(){
        return distinction;
    }

    @Override
    public boolean equals(Object o){ //equals 메소드를 오버라이드. Arthropod이 가지는 변수들을 비교하여 같은 내용인지 확인하도록
        if (this == o) 
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Arthropod arthropod = (Arthropod) o;

        return bodyRegions == arthropod.bodyRegions &&
        pairsOfAntennae == arthropod.pairsOfAntennae &&
        respiration == arthropod.respiration &&
        metamorphosis == arthropod.metamorphosis &&
        pairsOfWings == arthropod.pairsOfWings &&
        numberOfLegs == arthropod.numberOfLegs &&
        Objects.equals(distinction, arthropod.distinction);
    }

    @Override
    public int hashCode(){ //equals를 오버라이드했기 때문에, hashCode() 또한 Arthropod의 내용을 토대로 계산하도록 변환
        return Objects.hash(bodyRegions, pairsOfAntennae, respiration, metamorphosis, 
                            pairsOfWings, numberOfLegs, distinction);
    }

    public String toString(){ //Arthropod 변수들을 출력
        return "BodyRegions: " + getBodyRegions() + "  PairsOfAntennae: " + getPairsOfAntennae() 
        + "  Respiration: " + getRespiration() + "  Metamorphosis: " + getMetamorphosis() + "  PairsOfWings: " 
        + getPairsOfWings() + "  NumberOfLegs: " + getNumberOfLegs() + "\nDistinction: " + getDistinction();
    }

    public static class ArthropodBuilder{ //Builder 패턴, Arthropod이 가지는 변수들을 가짐
        private int bodyRegions;
        private int pairsOfAntennae;
        private RespirationType respiration;
        private MetamorphosisType metamorphosis;
        private int pairsOfWings;
        private int numberOfLegs;
        private String distinction;   
        
        public ArthropodBuilder bodyRegions(int bodyRegions){ //builder의 메소드들을 통해서 Arthropod을 생성할 때 변수들의 내용을 입력받음
            this.bodyRegions = bodyRegions;                   
            return this;
        }

        public ArthropodBuilder pairsOfAntennae(int pairsOfAntennae){
            this.pairsOfAntennae = pairsOfAntennae;
            return this;
        }

        public ArthropodBuilder respiration(RespirationType respiration){
            this.respiration = respiration;
            return this;
        }

        public ArthropodBuilder metamorphosis(MetamorphosisType metamorphosis){
            this.metamorphosis = metamorphosis;
            return this;
        }

        public ArthropodBuilder pairsOfWings(int pairsOfWings){
            this.pairsOfWings = pairsOfWings;
            return this;
        }

        public ArthropodBuilder numberOfLegs(int numberOfLegs){
            this.numberOfLegs = numberOfLegs;
            return this;
        }

        public ArthropodBuilder distinction(String distinction){
            this.distinction = distinction;
            return this;
        }

        public Arthropod build() { //build()를 통해 앞선 메소드들이 사용되었을 경우, 해당 내용들을 포함하여 Arthropod 생성
			return new Arthropod(this);
		}
    }

}
