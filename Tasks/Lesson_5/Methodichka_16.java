package Tasks.Lesson_5;

/* Определите сумму элементов одномерного массива, расположенных между
минимальным и максимальным значениями.
 */

import java.util.Random;

public class Methodichka_16 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[rand.nextInt(6) + 7];
        System.out.print("Our array: ");
        int max = 0, maxIndex = 0;
        int min = 0, minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(20) + 1;
            if (min == 0) min = array[i];
            if (max <= array[i]) {
                max = array[i];
                maxIndex = i;
            }
            if (min >= array[i]) {
                min = array[i];
                minIndex = i;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.println("Our max value: " + max + " with index: " + maxIndex);
        System.out.println("Our min value: " + min + " with index: " + minIndex);
        int count = 0;
        if (maxIndex > minIndex) {
            for (int i = minIndex; i <= maxIndex; i++) {
                count += array[i];
            }
        } else {
            for (int i = maxIndex; i <= minIndex; i++) {
                count += array[i];
            }
        }
        System.out.println("The sum of elements: " + count);

    }
}
