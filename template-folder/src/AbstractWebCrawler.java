//WEEK12-LAB8
//자바프로그래밍2-2분반2024-11-22
//32190063 강승민

public abstract class AbstractWebCrawler {
    public final void crawlWebsite(){ // 아래 메소드들을 통해 궁극적으로 원하는
        connectToWebsite();            // Template Method
        fetchPage();
        parsePage();
        process();
        disconnectFromWebsite();
    }
    public abstract void connectToWebsite(); // 웹사이트 연결 출력
    public abstract void fetchPage(); // 웹사이트 실제 연결
    public abstract void parsePage(); // 웹사이트 파싱 출력
    public abstract void process(); // 사이트에서 필요한 실제 프로세스 작업
    public void disconnectFromWebsite(){ // 웹사이트 종료 출력
        System.out.println("Disconnecting...\n");
    }
}
