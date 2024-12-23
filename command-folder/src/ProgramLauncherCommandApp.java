//WEEK10-LAB6
//자바프로그래밍2-2분반2024-11-08
//32190063 강승민
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ProgramLauncherCommandApp extends JFrame { 
    
    // Invoker와 Importer 생성
    private ProgramLauncherCommandInvoker launcher = new ProgramLauncherCommandInvoker();
    private ProgramLauncherCommandImporter importer = new ProgramLauncherCommandImporter();
    // 사용할 HashMap
    private Map<String, ProgramLauncherCommand> commandsMap;

    public ProgramLauncherCommandApp() { 
        // 실행될 디스플레이 설정
        setTitle("Program Launcher with Icons");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        // Load commands from JSON 
        // Importer를 통해 commands.json에서 데이터를 읽어와 Map에 저장
        // String과 ProgramLauncherCommand 가 Map에 저장
        commandsMap = importer.loadCommandsFromJson("commands.json");


        // Create buttons dynamically based on commandsMap 
        // commandsMap에 저장된 이름과 ProgramLauncherCommand를 통해 버튼 생성
        // 추가적으로 Wordpad를 commands.json에 작성했습니다
        for (Map.Entry<String, ProgramLauncherCommand> entry : commandsMap.entrySet()) { 
            // createButtonWithIcon을 통해 버튼 생성
            JButton button = createButtonWithIcon(entry.getKey(), entry.getValue()); 
            // Trigger execute in invoker 
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    // 버튼이 눌리면 setCommand를 통해 현재 ProgramLauncherCommand로 설정
                    launcher.setCommand(entry.getValue());
                    // 이후 설정한 Command 실행
                    launcher.executeCommand();
                }
            });
            // Add button to the GUI 
            add(button);
        }
        
        // Add Undo button at the bottom 
        JButton undoButton = new JButton("Undo Last Command");
        undoButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                launcher.undoLastCommand(); // Trigger undo in invoker 
                // 마지막 실행 undo
            }
        });
        add(undoButton);

        // YourCode
        JButton redoButton = new JButton("Redo Last Command");
        redoButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { // 버튼 클릭 동작 설정
                launcher.redoLastCommand(); // Trigger undo in invoker 
                // undo로 중지한 행위를 다시 되돌리기
            }
        });
        add(redoButton); // redo 버튼 디스플레이 추가

        // 디스플레이 출력
        setVisible(true);
    }

    // 각 Icon별 버튼을 만드는 메소드
    public JButton createButtonWithIcon(String key, ProgramLauncherCommand command){
        JButton button = new JButton(key); //key = name으로, 아이콘 옆 이름 출력
        //get메소드를 통해 Icon 주소를 가져오고, 버튼의 아이콘 설정
        ImageIcon icon = new ImageIcon(command.getIcon()); 
        button.setIcon(icon);
        return button; // 버튼 반환
    }
}