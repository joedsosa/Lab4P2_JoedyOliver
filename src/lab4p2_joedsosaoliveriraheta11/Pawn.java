
package lab4p2_joedsosaoliveriraheta11;


public class Pawn extends Piece{

    
    
    

    public Pawn() {
    super();
    }

    public Pawn(int col, int row, String symbol) {
        super(col, row, symbol);
    }
    @Override
public boolean movimiento(int newrow, int newcol,Object [][] board) {
       return (newrow== row+1 && newcol==col);
    }
    
    
    
    
}
