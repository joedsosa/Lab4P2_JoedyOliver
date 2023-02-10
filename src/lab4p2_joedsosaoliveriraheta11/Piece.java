
package lab4p2_joedsosaoliveriraheta11;

public abstract class Piece {
    protected int col,row;
    protected char symbol;
    
    public abstract boolean movimiento (int row, int col);

    public Piece(int col, int row,char symbol) {
        this.col = col;
        this.row = row;
    }

    public Piece() {
    }

    @Override
    public abstract String toString();
        
    
      
    
}
