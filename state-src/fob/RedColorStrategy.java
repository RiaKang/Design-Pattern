package fob;

import java.awt.Color;
import java.awt.Graphics2D;

public class RedColorStrategy implements BoidStrategy{
    @Override
    public void colorSetting(Graphics2D g2d) {
        g2d.setColor(Color.RED); // boid를 출력할 g2d에서 색상을 RED로 설정
    }
}
