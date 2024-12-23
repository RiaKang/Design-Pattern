package template;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HatDecorator extends DollDecorator{

    public HatDecorator(Doll decoratedDoll) {
        super(decoratedDoll);
        try {
            File imageFile = new File("image/hat.png"); //경로 설정
            image = ImageIO.read(imageFile); //파일에서 이미지 읽어오기
            image = image.getScaledInstance(500, 400, Image.SCALE_SMOOTH); //크기 조절
        } catch (IOException e) {
            System.out.println("Image Load Error: " + e.getMessage());
        }
    }
    @Override 
    public void paintComponent(Graphics g){ 
        super.paintComponent(g); // decorated paintComponent 
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) 
            g2.drawImage(image, -30, -50, this);
    }
    @Override
    public String describe(){
        return this.decoratedDoll.describe() + " with Hat";
    }

}
