package Tasks.Lesson_5;

//Создать двухмерный квадратный массив, и заполнить его «бабочкой».

import java.util.Scanner;

public class Methodichka_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        int count = n / 2;


        for (int i = 0; i < array.length; i++) {
            for (int k = i; k < array[i].length - i; k++) {
                array[i][k] = 1;
            }
        }
        int ns = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = i; j >= ns; j--) {
                array[i][j] = 1;
            }
            ns++;
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
}
