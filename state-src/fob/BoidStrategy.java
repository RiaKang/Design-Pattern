package fob;

import java.awt.Graphics2D;

// Strategy 패턴 인터페이스
public interface BoidStrategy {
    // Strategy 메소드로 각 클래스에서 색상 설정
    public void colorSetting(Graphics2D g2d);
}
