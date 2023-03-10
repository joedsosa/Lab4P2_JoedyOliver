package lab4p2_joedsosaoliveriraheta11;

import java.util.Scanner;

public class Lab4P2_JoedSosaOliverIraheta11 {

    public static Object[][] board = new Object[8][8];
    static Scanner rm = new Scanner(System.in);
    static boolean player = true;

    public static void main(String[] args) {
        boolean x = true;
        while (x) {
            creartablero();
            imprimirTablero(board);
            System.out.println("Ingrese su nombre jugador de piezas blancas");
            rm = new Scanner(System.in);
            String nameBlanco = rm.nextLine();
            System.out.println("Ingrese su nombre jugador de piezas negras");
            rm = new Scanner(System.in);
            String nameNegro = rm.nextLine();
            boolean y = true;
            while (y) {

                imprimirTablero(board);
                //false = negro / true = blanco
                String playername = nameBlanco;
                if (!player) {
                    playername = nameNegro;
                    player = true;
                } else {
                    player = false;
                }
                boolean u = true;
                while (u) {
                    
                    System.out.println(playername + " Ingrese siguiente movimiento");
                    rm = new Scanner(System.in);
                    String mov = rm.nextLine();

                    if (mov.equalsIgnoreCase("gusbai")) {
                        y = false;
                        break;
                    }
                    String pieza = mov.split("\\|")[0];
                    String ubicacionActual = mov.split("\\|")[1].split("-")[0];
                    String destino = mov.split("\\|")[1].split("-")[1];

                    int col = getNumber(ubicacionActual.charAt(0));
                    int row = Integer.parseInt(ubicacionActual.substring(1));
                    int newcol = getNumber(destino.charAt(0));
                    int newrow = Integer.parseInt(destino.substring(1));

                    u = hacerMove(row, col, newrow, newcol);
                    if (jaque()==false) {
                        System.out.println("Usted esta en jaque");
                        break;
                    }
                    if (jaquemate()==true) {
                        System.out.println("Partida terminada gano "+playername);
                        y = false;
                        break;
                    }
                }

            }
        }
    }

    public static boolean jaque() {
        int kingRow = -1;
        int kingCol = -1;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = (Piece) board[row][col];
                if (piece instanceof King ) {
                    kingRow = row;
                    kingCol = col;
                    break;
                }
            }
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = (Piece) board[row][col];
                if (piece != null && piece.isValidAttack(row, col, kingRow, kingCol, board)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean jaquemate() {
        if (!jaque()) {
            return false;
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = (Piece) board[row][col];
                if (piece instanceof King ) {
                    for (int newRow = 0; newRow < 8; newRow++) {
                        for (int newCol = 0; newCol < 8; newCol++) {
                            if (piece.movimiento(newRow, newCol, board)) {

                                return false;
                            }
                        }
                    }
                }
            }
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = (Piece) board[row][col];
                if (piece != null ) {
                    for (int newRow = 0; newRow < 8; newRow++) {
                        for (int newCol = 0; newCol < 8; newCol++) {
                            if (piece.movimiento(newRow, newCol, board)) {
                                Piece capturedPiece = (Piece) board[newRow][newCol];
                                board[newRow][newCol] = piece;
                                board[row][col] = null;
                                if (!jaque()) {
                                    board[row][col] = piece;
                                    board[newRow][newCol]=null;
    
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean hacerMove(int x1, int y1, int x2, int y2) {
        boolean u = false;
        Piece pieza = (Piece) board[x1][y1];

        if (pieza == null) {
            System.out.println("No se encontro pieza en esa ubicacion");
            u = true;
        } else {
            if (!pieza.movimiento(x2, y2, board)) {
                
                    board[x2][y2] = pieza;
                board[x1][y1] = null;
                
                
            } else {
                System.out.println("Movimiento No valido");
                u = true;
            }
        }
        return u;
    }

    public static int getNumber(char z) {
        int a = 0;
        switch (z) {
            case 'A','a' ->
                a = 0;
            case 'B','b' ->
                a = 1;
            case 'C','c' ->
                a = 2;
            case 'D','d' ->
                a = 3;
            case 'E','e' ->
                a = 4;
            case 'F','f' ->
                a = 5;
            case 'G','g' ->
                a = 6;
            case 'H','h' ->
                a = 7;
        }
        return a;
    }

    public static void imprimirTablero(Object[][] board) {

        System.out.println("    A  B  C  D  E  F  G  H");
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < 8; j++) {
                Object piece = board[i][j];
                if (piece == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print(piece.toString());
                }
            }
            System.out.println();
        }
    }

    public static void creartablero() {

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(1, i, "[p]");
            board[6][i] = new Pawn(6, i, "[P]");
        }

        board[0][0] = new Rook(0, 0, "[r]");
        board[0][7] = new Rook(0, 7, "[r]");
        board[7][0] = new Rook(7, 0, "[R]");
        board[7][7] = new Rook(7, 7, "[R]");
        board[0][1] = new Knight(0, 1, "[n]");
        board[0][6] = new Knight(0, 6, "[n]");
        board[7][1] = new Knight(7, 1, "[N]");
        board[7][6] = new Knight(7, 6, "[N]");
        board[0][2] = new Bishop(0, 2, "[b]");
        board[0][5] = new Bishop(0, 5, "[b]");
        board[7][2] = new Bishop(7, 2, "[B]");
        board[7][5] = new Bishop(7, 5, "[B]");
        board[0][3] = new Queen(0, 3, "[q]");
        board[7][3] = new Queen(7, 3, "[Q]");
        board[0][4] = new King(0, 4, "[k]");
        board[7][4] = new King(7, 4, "[K]");

    }

}
