package template;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HatDecorator4Dog extends DollDecorator{
    public HatDecorator4Dog(Doll decoratedDoll) {
        super(decoratedDoll);
        try {
            File imageFile = new File("image/hat4dog.png");
            image = ImageIO.read(imageFile);
            image = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println("Image Load Error: " + e.getMessage());
        }
    }
    @Override 
    public void paintComponent(Graphics g){ 
        super.paintComponent(g); // decorated paintComponent 
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) 
            g2.drawImage(image, 190, -20, this);
    }
    @Override
    public String describe(){
        return this.decoratedDoll.describe() + " with Hat";
    }
}