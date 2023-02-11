/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_joedsosaoliveriraheta11;

/**
 *
 * @author joeds
 */
public class Rook extends Piece {

    public Rook(int col, int row, String symbol) {
        super(col, row, symbol);
    }

    @Override
    public boolean movimiento(int newrow, int newcol, Object[][] board) {
        return (newrow == row || newcol == col);

    }

    public boolean isValidAttack(int row, int col, int newrow, int newcol, Object[][] board) {
        if (row == newrow || col == newcol) {
            int xMin = Math.min(row, newrow);
            int xMax = Math.max(row, newrow);
            int yMin = Math.min(col, newcol);
            int yMax = Math.max(col, newcol);
            if (col == newrow) {
                for (int y = yMin + 1; y < yMax; y++) {
                    if (board[col][y] != null) {
                        return false;
                    }
                }
            } else {
                for (int x = xMin + 1; x < xMax; x++) {
                    if (board[x][col] != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
