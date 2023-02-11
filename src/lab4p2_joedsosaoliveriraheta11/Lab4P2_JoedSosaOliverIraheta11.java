package lab4p2_joedsosaoliveriraheta11;

import java.util.Arrays;
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
                //false = negro / true = blanco
                String playername = nameBlanco;
                if (!player) {
                    playername = nameNegro;
                    player = true;
                } else {
                    player = false;
                }
                System.out.println(playername + " Ingrese siguiente movimiento");
                rm = new Scanner(System.in);
                String mov = rm.nextLine();

                if (mov.equalsIgnoreCase("gusbai")) {
                    //y = false;
                    break;
                }
                String pieza = mov.split("\\|")[0];
                String ubicacionActual = mov.split("\\|")[1].split("-")[0];
                String destino = mov.split("\\|")[1].split("-")[1];

                int col = getNumber(ubicacionActual.charAt(0));
                int row = ubicacionActual.charAt(1);
                int newcol = getNumber(destino.charAt(0));
                int newrow = destino.charAt(1);
                hacerMove(row, col, newrow,newcol);
            }
        }
    }

    public static void hacerMove(int x1,int y1,int x2,int y2) {
        Piece pieza = (Piece) board[x1][y1];
        if (pieza == null) {
            System.out.println("No piece found at source coordinates.");
        } else {
            if (pieza.movimiento(y2, y2)) {
                board[x2][y2] = pieza;
                board[x1][y1] = null;
            } else {
                System.out.println("Invalid move.");
            }
        }

    }

    public static int getNumber(char z) {
        int a = 0;
        switch (z) {
            case 'A' ->
                a = 0;
            case 'B' ->
                a = 1;
            case 'C' ->
                a = 2;
            case 'D' ->
                a = 3;
            case 'E' ->
                a = 4;
            case 'F' ->
                a = 5;
            case 'G' ->
                a = 6;
            case 'H' ->
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
