package template;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.awt.Image;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class ToyDecorator4Dog extends DollDecorator{
    Random random = new Random();

    public ToyDecorator4Dog(Doll decoratedDoll) {
        super(decoratedDoll);
        try {
            File imageFile = new File("image/toy4dog.png");
            image = ImageIO.read(imageFile);
            image = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println("Image Load Error: " + e.getMessage());
        }
    }
    @Override 
    public void paintComponent(Graphics g){ 
        int x = random.nextInt(300);
        int y= random.nextInt(400);
        super.paintComponent(g); // decorated paintComponent 
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) 
            g2.drawImage(image, x, y, this);
    }
    @Override
    public String describe(){
        return this.decoratedDoll.describe() + " with Toy";
    }
}