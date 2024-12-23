package fob;

import java.awt.Color;
import java.awt.Graphics2D;

public class GreenColorStrategy implements BoidStrategy{
    @Override
    public void colorSetting(Graphics2D g2d) {
        g2d.setColor(Color.GREEN); // boid를 출력할 g2d에서 색상을 GREEN으로 설정
    }
    
}