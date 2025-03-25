import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTTileButton extends JButton {
    private final Game game;
    private final TTTBoard board;

    public TTTTileButton(int row, int col, Game game, TTTBoard board) {
        this.game = game;
        this.board = board;

        setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
        addActionListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (getText().equals("")) {
                setText(game.getCurrentPlayer().toString());
                setEnabled(false);

                if (board.checkWin(game.getCurrentPlayer())) {
                    game.gameOver("Player " + game.getCurrentPlayer() + " wins!");
                } else if (board.isBoardFull()) {
                    game.gameOver("It's a draw!");
                } else {
                    game.switchPlayer();
                }
            }
        }
    }
}
