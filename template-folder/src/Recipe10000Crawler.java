//WEEK12-LAB8
//자바프로그래밍2-2분반2024-11-22
//32190063 강승민
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Recipe10000Crawler extends AbstractWebCrawler{
    String url;
    Document document;

    public Recipe10000Crawler(String url){ // 만개의 레시피 페이지 url을 생성자로 받기
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
    public void process() { // 실제 필요한 레시피 정보 가져오는 프로세스
        int i = 0; // 레시피 출력 갯수 제한을 위한 변수

        // ppt에서 요구하는 내용들의 출력을 위해서, 해당 내용을 포함하는 것은 "베스트 레시피" 이며
        // 다른 공동구매 및 부수적인 내용을 제외하고 레시피 관련 내용만 가져오기 위해 recipes 설정
        Elements recipes = document.select("ul.common_sp_list_ul.ea5 > li");

        // 가져온 "베스트 레시피"에 대해서 for문 반복
        for (Element recipe : recipes){
            if (i >= 5) break; // 레시피 갯수가 많아서 출력을 5개로 제한

            // 제목, 이미지, Link를 select하여 변수에 저장
            String recipeTitle = recipe.select(".common_sp_caption_tit").text(); // 레시피 제목
            String recipeImage = recipe.select("img").attr("src"); // 레시피 이미지
            String recipeLink = recipe.select("a").attr("href"); // 레시피 링크
            // 변수 출력
            System.out.println("Recipe Title : " + recipeTitle);
            System.out.println("Recipe Image : " + recipeImage);
            System.out.println("Recipe Link : " + recipeLink);

            try {
                // 해당하는 레시피페이지를 기존 만개의 레시피 url에 추가 링크까지하여 연결
                Document recipePage = Jsoup.connect(url + recipeLink).get();
                // 해당 레시피 페이지에서 ingredient (재료) 정보 select
                Elements ingredientElements = recipePage.select(".ready_ingre3 ul li");
                // Description은 기존 코드를 통해서 출력이 되지 않아 수정하였습니다.
                // 해당하는 "베스트레시피" 페이지에서 description에 해당하는 부분을 뽑아와
                // .text()를 통해 String으로 저장
                String recipeDescription = recipePage.select(".view2_summary_in").text();
                // Description 및 재료 출력
                System.out.println("Recipe Description : " + recipeDescription);
                System.out.println("Ingredient : ");
                for (Element ingredientElement : ingredientElements) {
                    String ingredient = ingredientElement.text();
                    System.out.println(ingredient);
                }
            } catch (IOException e) {
                e.printStackTrace(); // get에 대한 예외 처리
            }
            i++; // 출력 제한을 위한 i++
        }
    }
}
