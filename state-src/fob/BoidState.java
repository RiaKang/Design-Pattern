package fob;

import java.util.List;

public interface BoidState { // 각 State들이 implements할 인터페이스
    void applyBehavior(Boid boid, List<Boid> boids); // boid의 행동 제어 메소드
}
