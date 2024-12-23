package template;

public class Book extends LibraryItem{
    private String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
        //TODO Auto-generated constructor stub
    }

    public String getAuthor(){
        return author;
    }

    public void generateReport() {
        System.out.println("Title: " + getTitle() + ", Author: " + author);
    }
}
