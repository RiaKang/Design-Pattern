package fob;

import java.awt.Point;
import java.util.List;

public class AlignmentState implements BoidState{
    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {
        Point avgVelocity = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            if (other != boid && boid.getPosition().distance(other.getPosition()) < Boid.NEIGHBOR_DISTANCE) {
                avgVelocity.translate(other.getVelocity().x, other.getVelocity().y); // 평균 Velocity 설정
                count++; // boid 수 계산
            }
        }

        if (count > 0) {
            avgVelocity.x /= count; // 군집에 포함된 boid 수 만큼 나누기
            avgVelocity.y /= count;
            // 군집 boid 수로 나눈 값을 평균Velocity로 설정
            avgVelocity.translate(-boid.getVelocity().x, -boid.getVelocity().y);
        }

        boid.applyForce(avgVelocity);

        // check for nearby boids to join a flock
        for (Boid other : boids) {
            if (other != boid && boid.getPosition().distance(other.getPosition()) < Boid.SEPARATION_DISTANCE) {
                System.out.println("boid id=" + boid.getId() + "state=" + boid.getState() + " changed to SeperationState");
                boid.setState(new SeperationState());
                return; // transition to CohesionState if nearby boids are found
            }
        }
    }

    @Override
    public String toString() {
        return "AlignmentState";
    }
}
