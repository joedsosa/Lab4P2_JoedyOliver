/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_joedsosaoliveriraheta11;

public class Bishop extends Piece {

    public Bishop(int col, int row, String symbol) {
        super(col, row, symbol);
    }

    @Override
    public boolean movimiento(int newrow, int newcol, Object[][] board) {
        return (Math.abs(newrow - row) == Math.abs(newcol - col));

    }
    

    public boolean isValidAttack(int row, int col, int newrow, int newcol, Piece[][] board) {
        int xDiff = Math.abs(newrow - row);
        int yDiff = Math.abs(newcol - col);
        if (xDiff == yDiff) {

            int xMin = Math.min(row, newrow);
            int xMax = Math.max(row, newrow);
            int yMin = Math.min(col, newcol);
            int yMax = Math.max(col, newcol);
            int x = xMin + 1;
            int y = yMin + 1;
            while (x < xMax && y < yMax) {
                if (board[x][y] != null) {
                    return false;

                }
            }

        }
        return true;
    }
}