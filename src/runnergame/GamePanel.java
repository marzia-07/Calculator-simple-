package runnergame;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
public class GamePanel extends JPanel implements ActionListener{

    GamePanel(){
        this.setPreferredSize(new Dimension(800,600));
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.PINK);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.white);
        g.fillRect(100,100,50,200);
        g.setColor(Color.white);
        g.fillRect(600,100,50,200);
        g.setColor(Color.white);
        g.fillRect(300,400,200,50);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}