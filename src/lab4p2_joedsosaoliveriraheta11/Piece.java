
package lab4p2_joedsosaoliveriraheta11;

public abstract class Piece {
    protected int col,row;
    protected String symbol;
    
  

    public abstract boolean movimiento (int newrow, int newcol, Object [][] board);

    public Piece(int col, int row,String symbol) {
        this.col = col;
        this.row = row;
        this.symbol = symbol;
    }

    public Piece() {
    }
     
    
    @Override
    public  String toString(){
        return this.symbol;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

   
        
    
      
    
}
