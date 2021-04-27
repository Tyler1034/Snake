import javax.swing.*;


public class Game extends JFrame{

    Board board = new Board();

    public Game(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        add(board);


    }

    public static void main(String[] args) {
        Game game = new Game();

    }
}
