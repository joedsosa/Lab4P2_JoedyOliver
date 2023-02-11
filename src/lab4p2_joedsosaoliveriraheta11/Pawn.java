package lab4p2_joedsosaoliveriraheta11;

public class Pawn extends Piece {

    private boolean x;

    public Pawn() {
        super();
    }

    public Pawn(int col, int row, String symbol) {
        super(col, row, symbol);
    }

    @Override
    public boolean movimiento(int newrow, int newcol, Object[][] board) {
        return (newrow == row + 1 && newcol == col);
    }

    public boolean isValidAttack(int row, int col, int newrow, int newcol, Object[][] board) {

        int direction = this.x == false ? -1 : 1;
        if (newrow == row + direction && (newcol == col + 1 || newcol == col - 1)) {
            return true;
        }
        return false;
    }

  
}
