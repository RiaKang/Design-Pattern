//WEEK10-LAB6
//자바프로그래밍2-2분반2024-11-08
//32190063 강승민
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class ProgramLauncherCommandImporter {

    public Map<String, ProgramLauncherCommand> loadCommandsFromJson(String filename){
        // JSON 파일을 읽어와 파싱하여 필요한 데이터로 사용하기 위한 메소드

        // JSONParser와 배열 Array, JSON 데이터를 매핑할 Map 선언
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray;
        Map<String, ProgramLauncherCommand> commandMap = new HashMap<>();

        try (FileReader reader = new FileReader(filename)) {
            // JSON 파일 파싱 --> JSONObject 형태로 변환
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // commands.json의 commands 배열 가져오기
            jsonArray = (JSONArray) jsonObject.get("commands");

            // 배열의 JSONObject 데이터 하나씩 반복
            for (Object obj : jsonArray) {
                // 각 객체 JSONObject로 변환
                JSONObject commandsObject = (JSONObject) obj;

                // JSON의 데이터 변수로 가져오기
                String name = (String) commandsObject.get("name");
                String executable = (String) commandsObject.get("executable");
                String icon = (String) commandsObject.get("icon");

                // 가져온 JSON 데이터를 통해 ProgramLauncherCommand 생성
                ProgramLauncherCommand plCommand = new ProgramLauncherCommand(executable, icon);
                // 이후 name과 Command 개체를 매핑하여 commandMap에 추가
                commandMap.put(name, plCommand);
            }
        } catch (IOException | ParseException e) { // 예외 처리
            e.printStackTrace();
        }
        return commandMap; // 최종적으로 매핑된 commandMap 반환
    }
    
}
