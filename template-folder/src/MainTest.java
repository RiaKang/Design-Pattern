//WEEK12-LAB8
//자바프로그래밍2-2분반2024-11-22
//32190063 강승민
public class MainTest {
    public MainTest(){
        // 출력이 너무 많기에 레시피 5개로 제한하여 출력하였습니다.
        // 만개의 레시피에 대한 url을 인자로 하여 crawler 생성
        System.out.println("10000Recipe Page");
        AbstractWebCrawler crawler = new Recipe10000Crawler("https://www.10000recipe.com");
        crawler.crawlWebsite(); // 만개의 레시피 페이지 크롤링
        
        // crawler를 CGV 크롤러로 설정
        System.out.println("CGV Page");
        crawler = new CGVCrawler("http://www.cgv.co.kr/movies/?lt=1&ft=0");
        crawler.crawlWebsite(); // CGV 페이지 크롤링

        // YourCode
        System.out.println("Aladin Page");
        crawler = new YourCodeCrawler("https://www.aladin.co.kr/shop/common/wbest.aspx?BranchType=1&BestType=DailyBest&start=we");
        crawler.crawlWebsite(); // 알라딘 페이지 크롤링
    }
    
}
