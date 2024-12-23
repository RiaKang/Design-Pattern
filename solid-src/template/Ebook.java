package template;

public class Ebook extends Book implements Downloadable{

    public Ebook(String title, String author) {
        super(title, author);
        //TODO Auto-generated constructor stub
    }

    public void generateReport() {
        System.out.println("Title: " + getTitle() + ", Author: " + getAuthor());
    }

    public void download(){
        System.out.println(getTitle() + "is now downloading...");
    }
}
