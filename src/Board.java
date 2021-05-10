import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Board extends JPanel implements ActionListener {

    static final int ScreenWidth = 600;
    static final int ScreenHeight = 600;
    static final int UnitSize = 25;
    static final int GameUnits = (ScreenWidth*ScreenHeight)/UnitSize;
    static final int Delay = 75;
    final int x[] = new int[GameUnits];
    final int y[] = new int[GameUnits];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    Board(){

        random = new Random();
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame(){

        newApple();
        running = true;
        timer = new Timer(Delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){

        for(int i = 0; i < ScreenHeight/UnitSize; i ++){
            g.drawLine(i*UnitSize, 0,i*UnitSize, ScreenHeight);
            g.drawLine(0, i*UnitSize,ScreenWidth, i*UnitSize);
        }
        g.setColor(Color.RED);
        g.fillOval(appleX, appleY, UnitSize, UnitSize);
    }

    public void newApple(){
appleX = random.nextInt((int)(ScreenWidth/UnitSize)) * UnitSize;
appleY = random.nextInt((int)(ScreenHeight/UnitSize)) * UnitSize;
    }

   public void move(){

   }

   public void checkApple(){

   }

   public void checkCollisions(){

   }

   public void gameOver(Graphics g){

   }

@Override
    public void actionPerformed(ActionEvent e){

}

   public class MyKeyAdapter extends KeyAdapter{
        @Override
       public void keyPressed(KeyEvent e){

        }
   }


}

