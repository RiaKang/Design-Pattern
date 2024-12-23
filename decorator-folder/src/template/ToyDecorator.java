package template;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ToyDecorator extends DollDecorator{

    public ToyDecorator(Doll decoratedDoll) {
        super(decoratedDoll);
        try {
            // 이미지 파일 경로
            File imageFile = new File("image/toy.png");
            image = ImageIO.read(imageFile);
            image = image.getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        }catch (IOException e) {
            System.out.println("Image Load Error : " + e.getMessage());
        }
    }
    @Override 
    public void paintComponent(Graphics g){ 
        super.paintComponent(g); // decorated paintComponent 
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) 
            g2.drawImage(image, 280, 150, this);
    }
    @Override
    public String describe(){
        return this.decoratedDoll.describe() + " with Toy";
    }

}