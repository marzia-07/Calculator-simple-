package runnergame;
import javax.swing.*;

public class GameFrame extends JFrame {
    GamePanel panel;
    GameFrame()
    {
        this.setTitle("My 2D Snake Game");
        panel=new GamePanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
