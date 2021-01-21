package Tasks.Lesson3_HomeWork;

// Даны 3 целых числа.Найти количество положительных и отрицательных чисел в исходном наборе.

import java.util.Scanner;

public class Lesson3_Task5 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int firstNumber = x.nextInt();
        int secondNumber = x.nextInt();
        int thirdNumber = x.nextInt();

        int countPositive = 0;
        int countNegative = 0;
        if (firstNumber > 0) {
            countPositive++;
        } else if (firstNumber < 0) {
            countNegative++;
        } else {

        }
        if (secondNumber > 0) {
            countPositive++;
        } else if (secondNumber < 0) {
            countNegative++;
        } else {

        }
        if (thirdNumber > 0) {
            countPositive++;
        } else if (thirdNumber < 0) {
            countNegative++;
        } else {

        }
        System.out.println("The amount of positive numbers: " + countPositive);
        System.out.println("The amount of negative numbers: " + countNegative);

    }
}
