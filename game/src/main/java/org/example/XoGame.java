package org.example;

import java.util.Scanner;

public class XoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean win = false;
        char player = 'X';
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        for (int move = 0; move < 9; move++) {
            coords input = getCoords(scanner);

            if (!isValidMove(input.x(), input.y())) {
                move--;
                continue;
            }

            if (!busyPosition(board, input.x(), input.y())) {
                move--;
                continue;
            }

            player = replacePlayer(input.y(), player, board[input.x()]);

            win = displayBoard(board, win);

            if (playerWin(win, board, input.x(), input.y())) {
                break;
            }
        }
        noneWin(win);
    }

    private static boolean displayBoard(char[][] board, boolean win) {
        System.out.println("     1    2    3 ");
        System.out.println("  +----+----+----+");

        for (int i = 0; i < board.length; i++) {
            win = possibleWins(win, board, i);
            System.out.print(i + 1 + " ");

            for (int j = 0; j < board.length; j++) {
                System.out.print("| " + " " + board[i][j] + " ");
            }

            System.out.println("|");
            System.out.println("  +----+----+----+");
        }
        return win;
    }

    private static boolean possibleWins(boolean win, char[][] board, int i) {
        win = linesWin(board, i, win);
        win = columnsWin(board, i, win);
        win = isDiagonal(board, win);
        return win;
    }

    private static coords getCoords(Scanner scanner) {
        System.out.print("Podaj współrzędna x(1-3): ");
        int x = scanner.nextInt() - 1;
        System.out.print("Podaj współrzędna y(1-3): ");
        int y = scanner.nextInt() - 1;
        return new coords(x, y);
    }

    private record coords(int x, int y) {
    }

    private static boolean linesWin(char[][] board, int i, boolean win) {
        if (board[i][0] != ' '
                && board[i][0] == board[i][1]
                && board[i][1] == board[i][2]) {
            win = true;
        }
        return win;
    }

    private static boolean columnsWin(char[][] board, int i, boolean win) {
        if (board[0][i] != ' '
                && board[0][i] == board[1][i]
                && board[1][i] == board[2][i]) {
            win = true;
        }
        return win;
    }

    private static boolean isDiagonal(char[][] board, boolean win) {
        if (board[0][0] != ' '
                && board[0][0] == board[1][1]
                && board[1][1] == board[2][2]) {
            win = true;
        }

        if (board[0][2] != ' '
                && board[0][2] == board[1][1]
                && board[1][1] == board[2][0]) {
            win = true;
        }
        return win;
    }

    private static void noneWin(boolean win) {
        if (!win) {
            System.out.println("Zaden gracz nie wygral");
        }
    }

    private static boolean playerWin(boolean win, char[][] board, int x, int y) {
        if (win) {
            System.out.println("Gracz "  + board[x][y]  + " wygral");
            return true;
        }
        return false;
    }

    private static boolean busyPosition(char[][] board, int x, int y) {
        if (board[x][y] != ' ') {
            System.out.println("Pole zajete, wybierz inne");
            return false;
        }
        return true;
    }

    private static char replacePlayer(int y, char player, char[] board) {
        board[y] = player;
        player = player == 'X' ? 'O' : 'X';
        return player;
    }

    private static boolean isValidMove(int x, int y) {
        if (x > 2 || y > 2 || x < 0 || y < 0) {
            System.out.println("Błąd, nie ma takiego pola");
            return false;
        }
        return true;
    }
}
