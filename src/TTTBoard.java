import javax.swing.*;
import java.awt.*;

public class TTTBoard {
    private final JPanel panel;
    private final TTTTileButton[][] tiles;
    private final Game game;

    public TTTBoard(Game game) {
        this.game = game;
        panel = new JPanel(new GridLayout(3, 3));
        tiles = new TTTTileButton[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                tiles[row][col] = new TTTTileButton(row, col, game, this);
                panel.add(tiles[row][col]);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public boolean checkWin(Player player) {
        String symbol = player.toString();
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (tiles[i][0].getText().equals(symbol) &&
                    tiles[i][1].getText().equals(symbol) &&
                    tiles[i][2].getText().equals(symbol)) return true;

            if (tiles[0][i].getText().equals(symbol) &&
                    tiles[1][i].getText().equals(symbol) &&
                    tiles[2][i].getText().equals(symbol)) return true;
        }

        if (tiles[0][0].getText().equals(symbol) &&
                tiles[1][1].getText().equals(symbol) &&
                tiles[2][2].getText().equals(symbol)) return true;

        if (tiles[0][2].getText().equals(symbol) &&
                tiles[1][1].getText().equals(symbol) &&
                tiles[2][0].getText().equals(symbol)) return true;

        return false;
    }

    public boolean isBoardFull() {
        for (TTTTileButton[] row : tiles) {
            for (TTTTileButton tile : row) {
                if (tile.getText().equals("")) return false;
            }
        }
        return true;
    }

    public void resetBoard() {
        for (TTTTileButton[] row : tiles) {
            for (TTTTileButton tile : row) {
                tile.setText("");
                tile.setEnabled(true);
            }
        }
    }
}
