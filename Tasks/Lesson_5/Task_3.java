package Tasks.Lesson_5;

// Вычислить: 1+2+4+8+...+2564)Составьте программу, вычисляющую A*B, не пользуясь операцией умножения.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_3 {
    public static void main(String[] args) throws IOException {

        int count = 0;
        for (int i = 1; i <= 2564; i *= 2) {
            count += i;
        }
        System.out.println("Count is: " + count);


        int anotherCount = 0;
        for (int i = 0; i <= 2564; i++) {
            anotherCount += i;
        }
        System.out.println("anotherCount is: " + anotherCount);


        // Составьте программу, вычисляющую A*B, не пользуясь операцией умножения.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number for multiplication: ");
        int firstNumber = Integer.parseInt(reader.readLine());
        System.out.println("Enter the number by which the multiply: ");
        int secondNumber = Integer.parseInt(reader.readLine());
        int multiplicationResult = 0;
        for (int i = 1; i <= secondNumber; i++) {
            multiplicationResult += firstNumber;
        }
        System.out.println("The result is: " + multiplicationResult);
    }
}
