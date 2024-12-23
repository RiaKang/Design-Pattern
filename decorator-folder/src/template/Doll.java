package template;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public abstract class Doll extends JPanel implements IDoll{
    Image image;

    public void paintComponent(Graphics g){ 
        
    }

    public String describe(){
        return "Doll";
    }
}
