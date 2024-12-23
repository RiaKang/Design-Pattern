//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

package Arthropod;

public enum MetamorphosisType { //Enum 클래스의 MetamorphosisType
    COMPLETE("COMPLETE"),
    INCOMPLETE("INCOMPLETE"),
    NONE("NONE"),
    VARIABLE("VARIABLE");

    private final String name;

    MetamorphosisType(String name){
        this.name = name;
    }
    
    public String toString(){
        return name;
    }
}
