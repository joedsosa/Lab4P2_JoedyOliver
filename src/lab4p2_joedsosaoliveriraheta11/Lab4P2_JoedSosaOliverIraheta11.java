package lab4p2_joedsosaoliveriraheta11;

import java.util.Scanner;

public class Lab4P2_JoedSosaOliverIraheta11 {

    public static Piece[][] board = new Piece[8][8];
    static Scanner rm = new Scanner(System.in);

    public static void main(String[] args) {
        boolean x = true;
        while (x) {
            creartablero();
            System.out.println("Ingrese su nombre jugador de piezas blancas");
            rm = new Scanner(System.in);
            String nameBlanco = rm.nextLine();
            System.out.println("Ingrese su nombre jugador de piezas negras");
            rm = new Scanner(System.in);
            String nameNegro = rm.nextLine();
            boolean y = true;
            while (y) {

            }
        }
    }

    private static void creartablero() {
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(1, i);
            board[6][i] = new Pawn(6, i);
        }

        board[0][0] = new Rook(0, 0);
        board[0][7] = new Rook(0, 7);
        board[7][0] = new Rook(7, 0);
        board[7][7] = new Rook(7, 7);
        board[0][1] = new Knight(0, 1);
        board[0][6] = new Knight(0, 6);
        board[7][1] = new Knight(7, 1);
        board[7][6] = new Knight(7, 6);
        board[0][2] = new Bishop(0, 2);
        board[0][5] = new Bishop(0, 5);
        board[7][2] = new Bishop(7, 2);
        board[7][5] = new Bishop(7, 5);
        board[0][3] = new Queen(0, 3);
        board[7][3] = new Queen(7, 3);
        board[0][4] = new King(0, 4);
        board[7][4] = new King(7, 4);

    }

}
