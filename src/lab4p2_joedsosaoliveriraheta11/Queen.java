/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_joedsosaoliveriraheta11;

/**
 *
 * @author joeds
 */
public class Queen extends Piece{
public Queen(int col, int row, String symbol) {
        super(col, row, symbol);
    }
    @Override
    public boolean movimiento(int newrow, int newcol,Object [][] board) {
    return (newrow == row || newcol == col || Math.abs(newrow - row) == Math.abs(newcol - col));
    }

    
}
