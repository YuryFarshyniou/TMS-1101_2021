package Tasks.GameTicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Game {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random rand = new Random();
        String[][] table = new String[4][4];
        System.out.println("Your initial table: ");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i == 0) {
                    table[i][j] = Integer.toString(j + 1);
                } else if (j == 0 && i > 0) {
                    table[i][j] = Integer.toString(i + 1);
                } else {
                    table[i][j] = "_";
                }
                System.out.print(table[i][j] + " ");
            }
            System.out.println(" ");
        }


        System.out.println("Do you want to play with crosses or zeroes?(x//0)");
        String choice = reader.readLine();
        if (choice.equals("x")) {
            while (true) {
                System.out.println("Enter the horizontal dot:");
                String x = reader.readLine();
                System.out.println("Enter the vertical dot: ");
                String y = reader.readLine();
                table[Integer.parseInt(y) - 1][Integer.parseInt(x) - 1] = "X";

                if (isWinner(table, choice)) {
                    showMatrix(table);
                    break;
                }
                if (!isEmpty(table)) {
                    System.out.println("Drawww!!!!");
                    break;
                }
                while (true) {
                    int x1 = rand.nextInt(3) + 1;
                    int y1 = rand.nextInt(3) + 1;
                    if (table[x1][y1].equals("_")) {
                        table[x1][y1] = "0";
                        break;
                    }
                }
                showMatrix(table);
                if (isWinner(table, choice)) break;
                if (!isEmpty(table)) break;
            }
        } else if (choice.equals("0")) {
            System.out.println("Crosses always make a move first!");
            while (true) {
                while (true) {
                    int x1 = rand.nextInt(3) + 1;
                    int y1 = rand.nextInt(3) + 1;
                    if (table[x1][y1].equals("_")) {
                        table[x1][y1] = "X";
                        break;
                    }
                }
                showMatrix(table);
                if (isWinner(table, choice)) break;
                if (!isEmpty(table)) {
                    System.out.println("Drawww!!!!");
                    break;
                }

                System.out.println("Enter the horizontal dot:");
                String x = reader.readLine();
                System.out.println("Enter the vertical dot: ");
                String y = reader.readLine();
                table[Integer.parseInt(y) - 1][Integer.parseInt(x) - 1] = "0";

                if (isWinner(table, choice)) {
                    showMatrix(table);
                    break;
                }
                if (!isEmpty(table)) {
                    System.out.println("Drawww!!!!");
                    break;
                }
            }
        } else {
            System.out.println("You chose wrong option.Please,try again.");
        }
    }

    // Выводит поле на экран.

    static void showMatrix(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    // Обработка результатов.

    static boolean isWinner(String[][] arr, String choice) {
        if (choice.equals("x")) {
            if (arr[1][1].equals("X") && arr[1][2].equals("X") && arr[1][3].equals("X")
                    || arr[1][1].equals("X") && arr[2][1].equals("X") && arr[3][1].equals("X") ||
                    arr[1][1].equals("X") && arr[2][2].equals("X") && arr[3][3].equals("X") ||
                    arr[1][3].equals("X") && arr[2][3].equals("X") && arr[3][3].equals("X") ||
                    arr[1][3].equals("X") && arr[2][2].equals("X") && arr[3][1].equals("X") ||
                    arr[3][1].equals("X") && arr[3][2].equals("X") && arr[3][3].equals("X") ||
                    arr[2][1].equals("X") && arr[2][2].equals("X") && arr[2][3].equals("X") ||
                    arr[1][2].equals("X") && arr[2][2].equals("X") && arr[3][2].equals("X")) {
                System.out.println("You won! My congratulations!");
                return true;

            } else if (arr[1][1].equals("0") && arr[1][2].equals("0") && arr[1][3].equals("0")
                    || arr[1][1].equals("0") && arr[2][1].equals("0") && arr[3][1].equals("0") ||
                    arr[1][1].equals("0") && arr[2][2].equals("0") && arr[3][3].equals("0") ||
                    arr[1][3].equals("0") && arr[2][3].equals("0") && arr[3][3].equals("0") ||
                    arr[1][3].equals("0") && arr[2][2].equals("0") && arr[3][1].equals("0") ||
                    arr[3][1].equals("0") && arr[3][2].equals("0") && arr[3][3].equals("0") ||
                    arr[2][1].equals("0") && arr[2][2].equals("0") && arr[2][3].equals("0") ||
                    arr[1][2].equals("0") && arr[2][2].equals("0") && arr[3][2].equals("0")) {
                System.out.println("You lose! Try again.");
                return true;
            }
        } else if (choice.equals("0")) {
            if (arr[1][1].equals("X") && arr[1][2].equals("X") && arr[1][3].equals("X")
                    || arr[1][1].equals("X") && arr[2][1].equals("X") && arr[3][1].equals("X") ||
                    arr[1][1].equals("X") && arr[2][2].equals("X") && arr[3][3].equals("X") ||
                    arr[1][3].equals("X") && arr[2][3].equals("X") && arr[3][3].equals("X") ||
                    arr[1][3].equals("X") && arr[2][2].equals("X") && arr[3][1].equals("X") ||
                    arr[3][1].equals("X") && arr[3][2].equals("X") && arr[3][3].equals("X") ||
                    arr[2][1].equals("X") && arr[2][2].equals("X") && arr[2][3].equals("X") ||
                    arr[1][2].equals("X") && arr[2][2].equals("X") && arr[3][2].equals("X")) {
                System.out.println("You lose! Try again.");
                return true;

            } else if (arr[1][1].equals("0") && arr[1][2].equals("0") && arr[1][3].equals("0")
                    || arr[1][1].equals("0") && arr[2][1].equals("0") && arr[3][1].equals("0") ||
                    arr[1][1].equals("0") && arr[2][2].equals("0") && arr[3][3].equals("0") ||
                    arr[1][3].equals("0") && arr[2][3].equals("0") && arr[3][3].equals("0") ||
                    arr[1][3].equals("0") && arr[2][2].equals("0") && arr[3][1].equals("0") ||
                    arr[3][1].equals("0") && arr[3][2].equals("0") && arr[3][3].equals("0") ||
                    arr[2][1].equals("0") && arr[2][2].equals("0") && arr[2][3].equals("0") ||
                    arr[1][2].equals("0") && arr[2][2].equals("0") && arr[3][2].equals("0")) {
                System.out.println("You won! My congratulations!");
                return true;
            }
        }
        return false;
    }


    // Проверяем,осталось ли место в матрице дял заполнения.

    static boolean isEmpty(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == "_") {
                    return true;
                }
            }
        }
        return false;
    }
}