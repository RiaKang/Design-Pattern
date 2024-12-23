package fob;
import javax.swing.JFrame;

public class FlockSimulationApp extends JFrame {
    public FlockSimulationApp() { // 실제 수행 과정
        super("2D Flock of Birds Simulation"); // 제목

        // YourCode
        // FlockPanel에 적용할 RED 색상 Strategy 생성
        RedColorStrategy redColorStrategy = new RedColorStrategy(); 
        // 선택한 색상 Strategy를 통해 FlockPanel의 boid 색상 설정
        this.add(new FlockPanel(redColorStrategy)); // 설정한 FlockPanel 사용

        // 다른 색상 Strategy를 사용하려면 아래 주석 처리를 풀고 사용합니다.
        // GreenColorStrategy greenColorStrategy = new GreenColorStrategy(); // FlockPanel에 적용할 GREEN 색상 Strategy 생성
        // this.add(new FlockPanel(greenColorStrategy));
        // BlueColorStrategy blueColorStrategy = new BlueColorStrategy(); // FlockPanel에 적용할 BLUE 색상 Strategy 생성
        // this.add(new FlockPanel(blueColorStrategy));

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
