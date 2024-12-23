package fob;

import java.awt.Point;
import java.util.List;
import java.util.Random;

public class WanderState implements BoidState{
    private static final int MAX_FORCE = 1;

    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {
        // random wandering behavior
        Random random = new Random(); // 랜덤값 생성
        // random값 기반 x, y값 설정
        int dx = random.nextInt(2 * MAX_FORCE + 1) - MAX_FORCE;
        int dy = random.nextInt(2 * MAX_FORCE + 1) - MAX_FORCE;

        boid.applyForce(new Point(dx, dy)); // velocity 설정

        // check for nearby boids to join a flock
        for (Boid other : boids) {
            if (other != boid && boid.getPosition().distance(other.getPosition()) < Boid.NEIGHBOR_DISTANCE) {
                System.out.println("boid id=" + boid.getId() + "state=" + boid.getState() + " changed to CohesionState");
                boid.setState(new CohesionState());
                return; // transition to CohesionState if nearby boids are found
            }
        }
    }

    @Override
    public String toString() {
        return "WanderState";
    }
}
