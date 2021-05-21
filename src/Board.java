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

        for(int i = 0; i < bodyParts; i++){
            if(i == 0){
                g.setColor(Color.GREEN);
                g.fillRect(x[i], y[i], UnitSize, UnitSize);
            }else{
                g.setColor(Color.ORANGE);
                g.fillRect(x[i], y[i], UnitSize, UnitSize);
            }
        }
    }

    public void newApple(){
appleX = random.nextInt((int)(ScreenWidth/UnitSize)) * UnitSize;
appleY = random.nextInt((int)(ScreenHeight/UnitSize)) * UnitSize;
    }

   public void move(){
for(int i = bodyParts; i >0; i --){
    x[i] = x[i-1];
    y[i] = y[i-1];
}
switch(direction){
    case'U':
    y[0] = y[0] - UnitSize;
    break;
    case'D':
        y[0] = y[0] + UnitSize;
        break;
    case'L':
        x[0] = x[0] - UnitSize;
        break;
    case'R':
        x[0] = x[0] + UnitSize;
        break;
}
   }

   public void checkApple(){

   }

   public void checkCollisions() {
       for (int i = bodyParts; i > 0; i--) {
           if ((x[0] == x[i] && y[0] == y[i])) {
               running = false;
           }
       }
       if (x[0] < 0) {
           running = false;
       }
       if (x[0] > ScreenWidth) {
           running = false;
       }
       if (y[0] < 0) {
           running = false;
       }
       if (y[0] > ScreenHeight) {
           running = false;
       }
       if (!running) {
           timer.stop();
       }
   }
   public void gameOver(Graphics g){

   }

@Override
    public void actionPerformed(ActionEvent e){
if(running){
    move();
    checkApple();
    checkCollisions();
}
repaint();
}

   public class MyKeyAdapter extends KeyAdapter{
        @Override
       public void keyPressed(KeyEvent e){
switch (e.getKeyCode()){
    case KeyEvent.VK_LEFT:
        if(direction != 'R'){
            direction = 'L';

        }
        break;

    case KeyEvent.VK_RIGHT:
        if(direction != 'L'){
            direction = 'R';

        }
        break;

    case KeyEvent.VK_UP:
        if(direction != 'D'){
            direction = 'U';

        }
        break;

    case KeyEvent.VK_DOWN:
        if(direction != 'U'){
            direction = 'D';

        }
        break;

}
        }
   }


}

