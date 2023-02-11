/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_joedsosaoliveriraheta11;

/**
 *
 * @author joeds
 */
public class Knight extends Piece {

    public Knight(int col, int row, String symbol) {
        super(col, row, symbol);
    }

    @Override
    public boolean movimiento(int newrow, int newcol, Object[][] board) {
        int rowDiff = Math.abs(newrow - row);
        int colDiff = Math.abs(newcol - col);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);

    }

    public boolean isValidAttack(int row, int col, int newrow, int newcol, Piece[][] board) {
        int xDiff = Math.abs(newrow - row);
        int yDiff = Math.abs(newcol - col);
        if (xDiff == 2 && yDiff == 1 || xDiff == 1 && yDiff == 2) {
            return true;
        }
        return false;
    }
}


