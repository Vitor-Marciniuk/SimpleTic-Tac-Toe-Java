package tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = 3;
        String[][] matrizTicTacToe = generateTicTacToe(size);
        generateTicTacToePanel(matrizTicTacToe);

        Boolean end = false;
        Scanner sc = new Scanner(System.in);
        Boolean isX = true;
        while(!end){
            String[] pos = sc.nextLine().split(" ");
            int posColumn = 0;
            int posRow = 0;

            try {
                posColumn = Integer.parseInt(pos[0]) - 1 ;
                posRow = Integer.parseInt(pos[1]) - 1;
                if (posRow > 2 && posRow >= 0 || posColumn > 2 && posColumn >= 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
                else if(!Objects.equals(matrizTicTacToe[posColumn][posRow], " ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    isX = !isX;
                    String player = !isX ? "X" : "O";
                    matrizTicTacToe[posColumn][posRow] = player;
                    generateTicTacToePanel(matrizTicTacToe);
                    if (matrizTicTacToe[0][0].equals(matrizTicTacToe[0][1]) && matrizTicTacToe[0][1].equals(matrizTicTacToe[0][2]) && !matrizTicTacToe[0][0].equals(" "))
                        end = whoWins(player, end);
                    else if (matrizTicTacToe[1][0].equals(matrizTicTacToe[1][1]) && matrizTicTacToe[0][1].equals(matrizTicTacToe[1][2]) && !matrizTicTacToe[1][0].equals(" "))
                        end = whoWins(player, end);
                    else if (matrizTicTacToe[2][0].equals(matrizTicTacToe[2][1]) && matrizTicTacToe[2][1].equals(matrizTicTacToe[2][2]) && !matrizTicTacToe[2][0].equals(" "))
                        end = whoWins(player, end);
                    else if (matrizTicTacToe[0][0].equals(matrizTicTacToe[1][0]) && matrizTicTacToe[1][0].equals(matrizTicTacToe[2][0]) && !matrizTicTacToe[0][0].equals(" "))
                        end = whoWins(player, end);
                    else if (matrizTicTacToe[0][1].equals(matrizTicTacToe[1][1]) && matrizTicTacToe[1][1].equals(matrizTicTacToe[2][1]) && !matrizTicTacToe[0][1].equals(" "))
                        end = whoWins(player, end);
                    else if (matrizTicTacToe[0][2].equals(matrizTicTacToe[1][2]) && matrizTicTacToe[1][2].equals(matrizTicTacToe[2][2]) && !matrizTicTacToe[0][2].equals(" "))
                        end = whoWins(player, end);
                    else if (matrizTicTacToe[0][0].equals(matrizTicTacToe[1][1]) && matrizTicTacToe[1][1].equals(matrizTicTacToe[2][2]) && !matrizTicTacToe[0][0].equals(" "))
                        end = whoWins(player, end);
                    else if (matrizTicTacToe[0][2].equals(matrizTicTacToe[1][1]) && matrizTicTacToe[1][1].equals(matrizTicTacToe[2][0]) && !matrizTicTacToe[0][2].equals(" "))
                        whoWins(player, end);
                    else if (countPlayers(matrizTicTacToe) == 9)
                        end = draw(end);
                    else
                        System.out.println("Impossible");
                }
            } catch (Exception e){
                System.out.println("You should enter numbers!");
            }
        }
    }

    public static String[][] generateTicTacToe(int size){
        int indexInputCharArray = 0;
        String input = "         ";
        char[] inputCharArray = input.toCharArray();
        String[][] matrizTicTacToe = new String[size][size];
        for (int c = 0; c < matrizTicTacToe.length; c++) {
            for (int m = 0; m < matrizTicTacToe[c].length; m++) {
                matrizTicTacToe[c][m] = matrizTicTacToe[c][m];
                matrizTicTacToe[c][m] = String.valueOf(inputCharArray[indexInputCharArray]);
                indexInputCharArray++;
            }
        }
        return matrizTicTacToe;
    }

    public static int countPlayers(String[][] matrizTicTacToe){
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < matrizTicTacToe.length; i++) {
            for (int j = 0; j < matrizTicTacToe[i].length; j++) {
                if(matrizTicTacToe[i][j].equals("X"))
                    xCount++;
                else if (matrizTicTacToe[i][j].equals("O"))
                    oCount++;
            }
        }
        return xCount + oCount;
    }

    public static boolean whoWins(String player, Boolean end){
        System.out.println(player + " wins");
        return !end;
    }

    public static Boolean draw(Boolean end){
        System.out.println("Draw");
        return !end;
    }

    public static void generateTicTacToePanel(String[][] matrizTicTacToe){
        System.out.println("---------");
        System.out.println("| " + matrizTicTacToe[0][0] + " " + matrizTicTacToe[0][1] + " " + matrizTicTacToe[0][2] + " |");
        System.out.println("| " + matrizTicTacToe[1][0] + " " + matrizTicTacToe[1][1] + " " + matrizTicTacToe[1][2] + " |");
        System.out.println("| " + matrizTicTacToe[2][0] + " " + matrizTicTacToe[2][1] + " " + matrizTicTacToe[2][2] + " |");
        System.out.println("---------");
    }
}