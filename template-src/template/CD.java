package template;

public class CD extends LibraryItem{
    private String artist;
    
    public CD(String title, String artist) {
        super(title);
        this.artist = artist;
        //TODO Auto-generated constructor stub
    }

    public void generateReport() {
        System.out.println("Title: " + getTitle() + ", Artist: " + artist);
    }
}
