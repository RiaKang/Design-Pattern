package fob;

import java.awt.Point;
import java.util.List;

public class SeperationState implements BoidState{
    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {
        Point steer = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            int distance = (int) boid.getPosition().distance(other.getPosition()); // 다른 boid와의 거리 변수
            if (other != boid && distance > 0 && distance < Boid.SEPARATION_DISTANCE) { // SEPARATION보다 작으면
                Point diff = new Point(boid.getPosition().x - other.getPosition().x, boid.getPosition().y - other.getPosition().y);
                steer.translate(diff.x / distance, diff.y / distance);
                count++;
            }
        }

        if (count > 0) {
            steer.x /= count; // 군집해당 boid 수만큼 나누기
            steer.y /= count;
        }
        boid.applyForce(steer); // velocity 설정

        // check for nearby boids to join a flock
        for (Boid other : boids) {
            // SEPARATION_DISTANCE보다 멀어진 boid에 대해
            if (other != boid && boid.getPosition().distance(other.getPosition()) > Boid.SEPARATION_DISTANCE) {
                System.out.println("boid id=" + boid.getId() + "state=" + boid.getState() + " changed to WanderState");
                boid.setState(new WanderState());
                return; // transition to CohesionState if nearby boids are found
            }
        }
    }

    @Override
    public String toString() {
        return "SeperationState";
    }
}
