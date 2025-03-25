import javax.swing.*;
import java.awt.*;

public class Game {
    private final JFrame frame;
    private final TTTBoard board;
    private Player currentPlayer;

    public Game() {
        frame = new JFrame("Tic Tac Toe");
        board = new TTTBoard(this);
        currentPlayer = Player.X;
    }

    public void start() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(board.getPanel(), BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }

    public void gameOver(String message) {
        JOptionPane.showMessageDialog(frame, message);
        board.resetBoard();
        currentPlayer = Player.X;
    }
}
