//WEEK12-LAB8
//자바프로그래밍2-2분반2024-11-22
//32190063 강승민
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YourCodeCrawler extends AbstractWebCrawler{
    String url;
    Document document;

    public YourCodeCrawler(String url){ // 알라딘 페이지 url을 생성자로 받기
        this.url = url;
    }

    @Override
    public void connectToWebsite() { // 웹사이트 연결한다는 메세지 출력
        System.out.println("Connecting Page : " + url);
    }

    @Override
    public void fetchPage() { // 실제 웹사이트에 get 요청을 통해 연결
        try{
            document = Jsoup.connect(url).get(); // GET 요청
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void parsePage() { // 페이지 Parsing 한다는 메세지 출력
        if (document != null){
            System.out.println("Start Parsing Page : " + url);
        }
    }

    @Override
    public void process(){
        int i = 0;
        // 알라딘 html의 ss_book_box 태그 읽어오기
        Elements books = document.select(".ss_book_box");
        // 전체 책에 대해서 반복
        for (Element book : books){
            if (i >= 10) break;
            String bookTitle = book.select("a.bo3").text(); // Title 정보
            String bookAuthor = book.selectFirst("a[href*='AuthorSearch']").text(); // 작가 정보
            String bookPublisher = book.selectFirst("a[href*='PublisherSearch']").text(); // 출판사 정보
            String bookPrice = book.selectFirst("em").text(); // 가격 정보

            // 각 책에서 읽어온 데이터 출력
            System.out.println("Title : " + bookTitle); // 제목
            System.out.println("Author : " + bookAuthor); // 작가
            System.out.println("Publisher : " + bookPublisher); // 출판사
            System.out.println("Price : " + bookPrice); // 가격
            System.out.println("");
            i++;
        }
    }
}
