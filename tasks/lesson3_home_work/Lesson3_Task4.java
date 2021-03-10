package tasks.lesson3_home_work;

//Даны 3 целых числа.Найти количество положительных чисел в исходном наборе.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson3_Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstNumber = Integer.parseInt(reader.readLine());
        int secondNumber = Integer.parseInt(reader.readLine());
        int thirdNumber = Integer.parseInt(reader.readLine());

        int count = 0;
        if (firstNumber > 0) {
            count++;
        }
        if (secondNumber > 0) {
            count++;
        }
        if (thirdNumber > 0) {
            count++;
        }
        System.out.println("Количество положительных чисел в наборе : " + count);
    }
}
