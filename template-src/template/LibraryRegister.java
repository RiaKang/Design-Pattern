package template;

public class LibraryRegister implements StampGenerator{
    private String name;

    public LibraryRegister(String name) {
        this.name = name;
    }
    
    public void resetName(){
        name = "none";
    }

    public String getName(){
        return name;
    }
}
