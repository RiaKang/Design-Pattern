//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

package Arthropod;

public enum ArthropodType { //Enum 클래스의 ArthropodType, Type에 대한 개체명을 반환
    ARACHNIDA("Spider"),
    CHILOPODA("Centipedes"),
    DIPLOPODA("Millipedes"),
    CRUSTACEA("Crabs"),
    ODONATA("Dragonflies"),
    ORTHOPTERA("Grasshoppers"),
    DIPTERA("Flies"),
    COLEOPTERA("Beetles"),
    LEPIDOPTERA("Butterflies"),
    HYMENOPTERA("Bees"),
    UNKNOWN("Unknown");

    private final String name;

    ArthropodType(String name){
        this.name = name;
    }
    
    public String toString(){
        return name;
    }
}
