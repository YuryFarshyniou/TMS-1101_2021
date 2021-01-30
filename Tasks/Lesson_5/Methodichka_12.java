package Tasks.Lesson_5;

//Найдите сумму первых n целых чисел, которые делятся на 3.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Methodichka_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the amount of simple numbers: ");
        int n = Integer.parseInt(reader.readLine());
        int maxNumber = 3 * n;
        int count = 0;
        for (int i = 1; i <= maxNumber; i++) {
            if (i % 3 == 0) {
                count += i;
                System.out.println("The number is: " + i);
            }
        }
        System.out.println("The sum is: " + count);
    }
}
