/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4p2_joedsosaoliveriraheta11;



public class Bishop  extends Piece {

  public Bishop(int col, int row, String symbol) {
        super(col, row, symbol);
    }

    public boolean movimiento(int newrow, int newcol,Object [][] board) {
       return (Math.abs(newrow- row) == Math.abs(newcol - col));

    }

  
    


}

