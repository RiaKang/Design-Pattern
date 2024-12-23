//WEEK10-LAB6
//자바프로그래밍2-2분반2024-11-08
//32190063 강승민
import java.util.Stack;

public class ProgramLauncherCommandInvoker { // Invoker 클래스
    // 필요 변수 선언
    private IProgramLauncherCommand command;
    private IProgramLauncherCommand undoCommand; //YourCode 사용 변수
    private Stack<IProgramLauncherCommand> commandStack = new Stack<IProgramLauncherCommand>();
    // 실행된 IProgramLauncherCommand를 Stack 형태로 넣어둘 Stack 변수
    
    public void setCommand(IProgramLauncherCommand command){
        // input command값을 통해 command 설정
        this.command = command;
    }

    public void executeCommand(){
        // 실행될 command를 Stack에 넣고
        commandStack.add(command);
        // command 실행
        command.execute();
    }

    public void undoLastCommand(){
        // Stack 비어있는지 확인
        if (commandStack.isEmpty()) {
            System.out.println("Undo할 프로세스가 없습니다.");
            return;
        }

        // undo 요청이 들어오면 Stack에서 pop(), 가장 최근 command가 나온다
        command = commandStack.pop();
        // pop() 된 가장 최근 command를 undo() --> destory()하여 종료함
        command.undo();

        // redo 동작을 위한 추가 코드
        undoCommand = command;
    }

    // YourCode
    // 일반적으로 redo는 undo를 한 직후, 해당 undo 동작에 대한 되돌리기를 진행한다.
    // 그러나
    // 해당 코드에서의 redo는 undo를 통해 중지한 직전의 Process를 다시 실행하는 것으로
    // undo를 통해 Process를 중지하고, 다른 작업을 수행하더라도
    // 이후 redo를 통해 undo로 중지한 Process를 다시 실행시킬 수 있다.
    public void redoLastCommand(){
        if (undoCommand == null) {
            System.out.println("Redo할 프로세스가 없습니다.");
            return;
        }

        commandStack.add(undoCommand); // 이전 undo로 중지한 커맨드 정보인 undoCommand를 스택에 추가
        undoCommand.execute(); // undo로 중지시켰던 것 다시 실행
    }
}
