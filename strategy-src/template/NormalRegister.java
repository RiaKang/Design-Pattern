package template;

public class NormalRegister extends LibraryRegister{
    private int stamp;

    public NormalRegister(String name) {
        super(name);
        this.stamp = 0;
    }

    public void addStamp(){
        stamp += 1; ////NormalRegister는 스탬프 1개씩 적립
    }

    public void viewStamp(){
        System.out.println(getName() + "'s stamp : " + stamp);
    }
}
