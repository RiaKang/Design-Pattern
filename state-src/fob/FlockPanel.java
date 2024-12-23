package fob;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class FlockPanel extends JPanel {
    // 패널 사이즈 및 전체 Boid 개수, Update 주기 설정
    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 600;
    private static final int NUM_BOIDS = 20;
    private static final int UPDATE_INTERVAL = 200;
    // boid 리스트 선언
    private List<Boid> boids;

    public FlockPanel(BoidStrategy boidStrategy) {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
        
        // create boids
        boids = new ArrayList<>();
        for (int i = 0; i < NUM_BOIDS; i++) {
            Boid boid = new Boid(PANEL_WIDTH, PANEL_HEIGHT);
            // YourCode
            // FlockPanel에서 boid 생성할 때 선택한 Strategy를 set
            boid.setStrategy(boidStrategy);
            boids.add(boid);
        }

        // create and start a Timer to update and repaint boids
        new Timer(UPDATE_INTERVAL, e -> {
            updateBoids();
            repaint();
        }).start();
    }

    // update each boid's position and behavior based on its current state
    private void updateBoids() {
        for (Boid boid : boids) {
            boid.flock(boids); // 설정한 State에 따라 applyBehavior이 수행됨
            boid.update();     // 위치 변경
        }
    }

    @Override
    protected void paintComponent(Graphics g) { // boid 그리기
        super.paintComponent(g);
        for (Boid boid : boids) {
            boid.draw(g);
            System.out.println(boid);
        }
    }
}
