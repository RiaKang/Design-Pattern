package template;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaperDollApp extends JFrame implements ActionListener{
    JButton[] button4cat = new JButton[4];
    JButton[] button4dog = new JButton[4];
    Doll doll; //doll
    Doll doll2;
    JPanel displayPanel4cat = new JPanel(new BorderLayout());
    JPanel displayPanel4dog = new JPanel(new BorderLayout());
    
    public PaperDollApp(){
        doll = new CatDoll();
        displayPanel4cat.add(doll, BorderLayout.CENTER);

        JPanel buttonPanel= new JPanel(new GridLayout(1,3));
        button4cat[0] = new JButton("Hat");
        button4cat[0].addActionListener(this);
        buttonPanel.add(button4cat[0]);

        button4cat[1] = new JButton("Ball");
        button4cat[1].addActionListener(this);
        buttonPanel.add(button4cat[1]);

        button4cat[2] = new JButton("Toy");
        button4cat[2].addActionListener(this);
        buttonPanel.add(button4cat[2]);

        button4cat[3] = new JButton("ChangeDog");
        button4cat[3].addActionListener(this);
        buttonPanel.add(button4cat[3]);

        displayPanel4cat.add(buttonPanel, BorderLayout.SOUTH);

        add(displayPanel4cat);

        setSize(600, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(doll.describe());
    }

    public void PaperDollApp4Dog() {
        doll2 = new DogDoll();
        displayPanel4dog.add(doll2, BorderLayout.CENTER);

        JPanel buttonPanel2 = new JPanel(new GridLayout(1,3));

        button4dog[0] = new JButton("Hat");
        button4dog[0].addActionListener(this);
        buttonPanel2.add(button4dog[0]);

        button4dog[1] = new JButton("Chew");
        button4dog[1].addActionListener(this);
        buttonPanel2.add(button4dog[1]);

        button4dog[2] = new JButton("Toy");
        button4dog[2].addActionListener(this);
        buttonPanel2.add(button4dog[2]);

        displayPanel4dog.add(buttonPanel2, BorderLayout.SOUTH);

        add(displayPanel4dog);

        setSize(600, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(doll2.describe());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayPanel4cat.remove(doll); // 기존 패널 제거
        if (e.getSource() == button4cat[0]) {
            doll = new HatDecorator(doll);
            displayPanel4cat.add(doll);
            button4cat[0].setEnabled(false);
            displayPanel4cat.revalidate(); // 출력 위치 재연산
            displayPanel4cat.repaint();    // 다시 출력
            System.out.println(doll.describe()); //describe 출력
        }
        else if (e.getSource() == button4cat[1]){
            doll = new BallDecorator(doll);
            displayPanel4cat.add(doll);
            button4cat[1].setEnabled(false);
            displayPanel4cat.revalidate(); 
            displayPanel4cat.repaint();   
            System.out.println(doll.describe());
        }
        else if (e.getSource() == button4cat[2]){
            doll = new ToyDecorator(doll);
            displayPanel4cat.add(doll);
            button4cat[2].setEnabled(false);
            displayPanel4cat.revalidate(); 
            displayPanel4cat.repaint();    
            System.out.println(doll.describe());
        }
        else if (e.getSource() == button4cat[3]){
            displayPanel4cat.removeAll();
            PaperDollApp4Dog();
        } //Dog 시작
        else if (e.getSource() == button4dog[0]){
            displayPanel4dog.remove(doll2);
            doll2 = new HatDecorator4Dog(doll2);
            displayPanel4dog.add(doll2);
            button4dog[0].setEnabled(false);
            displayPanel4dog.revalidate(); 
            displayPanel4dog.repaint();   
            System.out.println(doll2.describe());
        }
        else if (e.getSource() == button4dog[1]){
            displayPanel4dog.remove(doll2);
            doll2 = new ChewDecorator4Dog(doll2);
            displayPanel4dog.add(doll2);
            button4dog[1].setEnabled(false);
            displayPanel4dog.revalidate(); 
            displayPanel4dog.repaint();    
            System.out.println(doll2.describe());
        }
        else if (e.getSource() == button4dog[2]){
            displayPanel4dog.remove(doll2);
            doll2 = new ToyDecorator4Dog(doll2);
            displayPanel4dog.add(doll2);
            displayPanel4dog.revalidate(); 
            displayPanel4dog.repaint();   
            System.out.println(doll2.describe());
        }
    }

}
