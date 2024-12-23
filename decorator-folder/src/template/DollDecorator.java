package template;

import java.awt.Graphics;

public abstract class DollDecorator extends Doll{
    protected Doll decoratedDoll;

    public DollDecorator(Doll decoratedDoll){
        this.decoratedDoll = decoratedDoll;
    }

    @Override
    public String describe(){
        return decoratedDoll.describe();
    }

    @Override
    public void paintComponent(Graphics g){
        decoratedDoll.paintComponent(g);
    }
}
