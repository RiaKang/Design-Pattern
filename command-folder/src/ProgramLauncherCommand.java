//WEEK10-LAB6
//자바프로그래밍2-2분반2024-11-08
//32190063 강승민
public class ProgramLauncherCommand implements IProgramLauncherCommand{
    private String executable;
    private String icon;
    private Process process;

    public ProgramLauncherCommand(String executable, String icon) {
        this.executable = executable; //JSON파일에 있는 내용들
        this.icon = icon;
    }
    
    @Override
    public void execute() {
        try { // executable에 포함된 내용에서 " "으로 구분하여 ProcessBuilder 생성
            // Edge의 경우 cmd를 통해 start하기 때문
            ProcessBuilder pb = new ProcessBuilder(executable.split(" "));
            process = pb.start(); // ProcessBuilder를 통해 프로세스 생성, process 변수에 할당
        } catch (Exception e) {
            e.printStackTrace();    // 예외 설정
        }
    }

    @Override
    public void undo() {
        // Edge를 제외한 그림판, 메모장등의 프로세스는 process.destory()만으로도 온전히 종료가 되지만
        // Edge는 실행될 때 다수의 자식 프로세스와 함께 생성되기 때문에, destory()만으로는 종료가 되지 않습니다.
        // 따라서, processHandle을 통해 자식 프로세스까지 함께 종료할 수 있도록 제작합니다.

        ProcessHandle processHandle = process.toHandle(); // 해당 프로세스를 ProcessHandle로 변환
        processHandle.descendants()  // 자식 프로세스
                         .forEach(ProcessHandle::destroy);  // 모든 자식 프로세스 종료
    
        processHandle.destroyForcibly(); // 이후 부모 프로세스도 종료
    }

    // Getter Setter 메소드
    public String getExecutable() {
        return this.executable;
    }

    public void setExecutable(String executable) {
        this.executable = executable;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Process getProcess() {
        return this.process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}
