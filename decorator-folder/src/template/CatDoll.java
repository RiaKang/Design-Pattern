package template;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CatDoll extends Doll{
    public CatDoll(){
        try {
            // 이미지 파일 경로
            File imageFile = new File("image/cat.png");

            // 고양이 사진 로딩
            image = ImageIO.read(imageFile);
            image = image.getScaledInstance(500, 600, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            System.out.println("Image Load Error: " + e.getMessage());
        }
    }

    @Override
    public String describe() {
        return "Cat Doll";
    }

    @Override
    public void paintComponent(Graphics g){ 
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) 
            g2.drawImage(image, 50, 50, this);
    }
    
}
