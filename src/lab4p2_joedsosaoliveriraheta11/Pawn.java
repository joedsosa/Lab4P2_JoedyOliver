
package lab4p2_joedsosaoliveriraheta11;


public class Pawn extends Piece{

    @Override
    
    public boolean movimiento(int row, int col) {
       boolean ValidMove = false;
       return ValidMove;
    }

    public Pawn() {
    super();
    }

    public Pawn(int col, int row, char symbol) {
        super(col, row, symbol);
    }

    @Override
    public String toString() {
        return  "["+symbol+"]";
    }
    
    
    
    
}
