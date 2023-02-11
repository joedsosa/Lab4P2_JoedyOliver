
package lab4p2_joedsosaoliveriraheta11;

public class King extends Piece{
    
public King(int col, int row, String symbol) {
        super(col, row, symbol);
    }
    @Override
    public boolean movimiento(int newrow, int newcol,Object [][] board) {
        return (Math.abs(newrow - row) <= 1 && Math.abs(newcol - col) <= 1);
    }
    public boolean isValidAttack(int row, int col, int newRow, int newCol) {
        if (Math.abs(row - newRow) <= 1 && Math.abs(col- newCol) <= 1) {
            return true;
        }
        return false;
    }

}

