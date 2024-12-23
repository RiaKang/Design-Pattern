//WEEK12-LAB8
//자바프로그래밍2-2분반2024-11-22
//32190063 강승민
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CGVCrawler extends AbstractWebCrawler{
    String url;
    Document document;

    public CGVCrawler(String url){ // CGV 페이지 url을 생성자로 받기
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
    public void process() {
        // 필요한 데이터 중 title / txt-info / percent는 .box-contents 태그 내부에 존재하였지만,
        // image에 대한 데이터는 .box-image 태그로 따로 존재하였습니다.
        // 따라서, Element movie : movies 형태의 for each문으로는 image 정보 출력이 어려웠기 때문에
        // .box-contents와 .box-image에 대한 Elements를 따로 생성하여 for문을 통해 출력을 진행하였습니다.

        // html의 .box-contents 태그를 선택해 읽어오기
        Elements movies = document.select(".sect-movie-chart .box-contents");
        // html의 .box-image 태그를 선택해 읽어오기
        Elements movies2 = document.select(".sect-movie-chart .box-image");
        // 전체 영화에 대해서 반복
        for (int i = 0; i < movies.size(); i++){
            String movieTitle = movies.get(i).select(".title").text(); // Title 정보
            String releaseDate = movies.get(i).select(".txt-info strong").text(); // 영화 설명
            String rating = movies.get(i).select(".percent span").text(); // 예매율 정보
            String movieImage = movies2.get(i).select(".thumb-image img").attr("src"); // 이미지 정보

            // 각 영화에 대한 읽어온 데이터 출력
            System.out.println("Title : " + movieTitle);
            System.out.println("Release : " + releaseDate);
            System.out.println("Rating : " + rating);
            System.out.println("Image : " + movieImage);
            System.out.println("");
        }
    }
}
