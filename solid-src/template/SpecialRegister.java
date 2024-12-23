package template;

public class SpecialRegister extends LibraryRegister{
    private int stamp;

    public SpecialRegister(String name) {
        super(name);
        this.stamp = 0;
    }

    public void addStamp(){
        stamp += 2; //SpecialRegister는 스탬프 2개씩 적립
    }

    public void viewStamp(){
        System.out.println(getName() + "'s stamp : " + stamp);
    }
}
