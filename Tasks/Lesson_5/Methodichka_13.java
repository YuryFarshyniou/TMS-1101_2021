package Tasks.Lesson_5;

//Создать последовательность случайных чисел, найти и вывести наибольшее из них.

import java.util.Arrays;
import java.util.Random;

public class Methodichka_13 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[rand.nextInt(15)];
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(20) + 1;
            if (array[i] > max) max = array[i];
        }
        System.out.println("Our sequence: " + Arrays.toString(array));
        System.out.println("The max element in our sequence: " + max);
    }
}
