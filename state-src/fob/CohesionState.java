package fob;

import java.awt.Point;
import java.util.List;

public class CohesionState implements BoidState{
    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {
        Point center = new Point(0, 0); // 군집 중앙 계산을 위한 center 변수
        int count = 0;

        for (Boid other : boids) { // 전체 boids에 대해서
            // Cohesion에 해당하는 boid만
            if (other != boid && boid.getPosition().distance(other.getPosition()) < Boid.NEIGHBOR_DISTANCE) {
                center.translate(other.getPosition().x, other.getPosition().y);
                count++; // 군집 중앙 계산
            }
        }

        if (count > 0) { // boid가 0개 이상일 때(존재할 때)
            center.x /= count; // 전체 군집 boid 수에 따라 중앙값 나누기
            center.y /= count;
            center.translate(-boid.getPosition().x, -boid.getPosition().y);
        }

        boid.applyForce(center);

        // check for nearby boids to join a flock
        for (Boid other : boids) {
            if (other != boid && boid.getPosition().distance(other.getPosition()) < Boid.JOIN_THRESHOLD) {
                System.out.println("boid id=" + boid.getId() + "state=" + boid.getState() + " changed to AlignmentState");
                boid.setState(new AlignmentState());
                return; // transition to CohesionState if nearby boids are found
            }
        }
    }

    @Override
    public String toString() {
        return "CohesionState";
    }
}
