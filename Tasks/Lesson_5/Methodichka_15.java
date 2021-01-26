package Tasks.Lesson_5;

/* Создать массив, заполнить его случайными элементами, распечатать,
перевернуть, и снова распечатать (при переворачивании нежелательно создавать
еще один массив).
 */

import java.util.Arrays;
import java.util.Random;

public class Methodichka_15 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[rand.nextInt(8) + 2];
        System.out.print("Our array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(20) + 1;
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
        int s = 0;
        s = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            if (i == s) break;
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println("Our reverse array: " + Arrays.toString(array));
    }
}
