package template;

public class DVD extends LibraryItem implements Streamable{
    private String director;
    private int duration;

    public DVD(String title, String director, int duration) {
        super(title);
        this.director = director;
        this.duration = duration;
        //TODO Auto-generated constructor stub
    }

    public void generateReport() {
        System.out.println("Title: " + getTitle() + ", Director: " + director + ", Duration: " + duration);
    }

    public void stream(){
        System.out.println(getTitle() + "is now streaming...");
    }
}
