package template;

public class LibraryItem implements ReportGenerator{
    private String title;

    public LibraryItem(String title) {
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
}
