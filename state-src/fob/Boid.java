package fob;

import java.util.List;
import java.util.Random;
// import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Boid {
    // Boid 행위 여부를 판단할 각종 변수 final 선언
    public static final int SPEED = 12;
    public static final int SEPARATION_DISTANCE = 20;
    public static final int NEIGHBOR_DISTANCE = 50; // == VISION_RANGE
    public static final int JOIN_THRESHOLD = 15;

    // 변수 선언
    private int id;
    private static int count = 0;
    private Point position;
    private Point velocity;
    private int panelWidth;
    private int panelHeight;
    private Random random;
    // State 선언
    private WanderState wanderState;
    private CohesionState cohesionState;
    private AlignmentState alignmentState;
    private SeperationState seperationState;
    private BoidState state;

    // YourCode
    private BoidStrategy boidStrategy;

    public Boid(int panelWidth, int panelHeight) { // Boid 생성자
        this.panelWidth = panelWidth; // JPanel 크기 변수
        this.panelHeight = panelHeight;
        // Boid에 적용할 position 및 velocity random으로 설정
        this.random = new Random();
        position = new Point(random.nextInt(panelWidth), random.nextInt(panelHeight));
        velocity = new Point(random.nextInt(2 * SPEED) - SPEED, random.nextInt(2 * SPEED) - SPEED);
        // 생성될 때 마다 count 증가해서 id 부여
        this.id = ++count;
        // 각 State 생성
        wanderState = new WanderState();
        cohesionState = new CohesionState();
        alignmentState = new AlignmentState();
        seperationState = new SeperationState();
        // WanderState로 시작
        this.state = wanderState;
    }

    public void flock(List<Boid> boids) {
        // 기존 sepe, align, cohe 합쳐서 계산하던 수식에서
        // 각 state 별 적용되는 applyBehavior를 통해 boid를 제어
        state.applyBehavior(this, boids);
        limitSpeed(); // 속도 제한
    }

    private Point separate(List<Boid> boids) {
        Point steer = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            int distance = (int) position.distance(other.position);
            if (other != this && distance > 0 && distance < SEPARATION_DISTANCE) {
                Point diff = new Point(position.x - other.position.x, position.y - other.position.y);
                steer.translate(diff.x / distance, diff.y / distance);
                count++;
            }
        }

        if (count > 0) {
            steer.x /= count;
            steer.y /= count;
        }
        return steer;
    }

    private Point align(List<Boid> boids) {
        Point avgVelocity = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            if (other != this && position.distance(other.position) < NEIGHBOR_DISTANCE) {
                avgVelocity.translate(other.velocity.x, other.velocity.y);
                count++;
            }
        }

        if (count > 0) {
            avgVelocity.x /= count;
            avgVelocity.y /= count;
            avgVelocity.translate(-velocity.x, -velocity.y);
        }
        return avgVelocity;
    }

    private Point cohere(List<Boid> boids) {
        Point center = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            if (other != this && position.distance(other.position) < NEIGHBOR_DISTANCE) {
                center.translate(other.position.x, other.position.y);
                count++;
            }
        }

        if (count > 0) {
            center.x /= count;
            center.y /= count;
            center.translate(-position.x, -position.y);
        }
        return center;
    }

    public void applyForce(Point force) { // 속도 조절 
        velocity.translate(force.x, force.y);
    }

    private void limitSpeed() { // 속도 제한 설정
        double magnitude = Math.sqrt(velocity.x * velocity.x + velocity.y * velocity.y);
        if (magnitude > SPEED) {
            velocity.x = (int) ((velocity.x / magnitude) * SPEED);
            velocity.y = (int) ((velocity.y / magnitude) * SPEED);
        }
    }

    public void update() { // 각 position을 update해서 변환함
        // FlockPanel에서 사용
        position.translate(velocity.x, velocity.y);
        // wrap-around at screen edges
        if (position.x < 0) position.x = panelWidth;
        else if (position.x > panelWidth) position.x = 0;
        if (position.y < 0) position.y = panelHeight;
        else if (position.y > panelHeight) position.y = 0;
    }

    // draw boid as a triangle (position, velocity)
    public void draw(Graphics g) { // boid를 그림으로 출력
        Graphics2D g2d = (Graphics2D)g;
   
        double angle = Math.atan2(velocity.y, velocity.x);
        
        g2d.translate(position.x, position.y);
        g2d.rotate(angle);

        int[] xPoints = {0, -10, -10};
        int[] yPoints = {0, -5, 5};
        // YourCode
        // 기존 g2d.setColor(Color.BLUE) 코드를
        // Strategy Pattern을 통해 선택된 Strategy의 색상으로 입력
        colorSetting(g2d);
        g2d.fillPolygon(xPoints, yPoints, 3);

        g2d.rotate(-angle);
        g2d.translate(-position.x, -position.y);
    }

    // State 설정
    public void setState(BoidState state){
        this.state = state;
    }

    // get 메소드 선언
    public Point getPosition() { return position; }
    public Point getVelocity() { return velocity; }
    public int getId() { return id; }
    public BoidState getState() { return state; }

    @Override // toString 오버라이드
    public String toString() {
        return "{" +
            ", position='" + getPosition() + "'" +
            ", velocity='" + getVelocity() + "'" +
                        "}";
    } 

    // YourCode
    // 색상 선택 Strategy를 선택하는 메소드
    public void setStrategy(BoidStrategy boidStrategy){
        this.boidStrategy = boidStrategy;
    }

    // Strategy 메소드로, Strategy에 따라 다른 색상으로 설정된다.
    public void colorSetting(Graphics2D g2d){
        boidStrategy.colorSetting(g2d);
    }
}
