//WEEK7-LAB5
//자바프로그래밍2-2분반2024-10-19
//2024-10-19-강승민

package Arthropod;

public enum RespirationType { //Enum 클래스의 RespirationType
    TRACHEAL("TRACHEAL"),
    BOOK_LUNGS("BOOK_LUNGS"),
    GILLS("GILLS");

    private final String name;

    RespirationType(String name){
        this.name = name;
    }
    
    public String toString(){
        return name;
    }
}
