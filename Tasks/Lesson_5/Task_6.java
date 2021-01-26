package Tasks.Lesson_5;

// Напишите программу, определяющую сумму всех нечетных чисел от 1 до 99
public class Task_6 {
    public static void main(String[] args) {
        int sumOfOddNumbers = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                sumOfOddNumbers += i;
            }
            System.out.println(i);
        }
        System.out.println("The sum of odd numbers: " + sumOfOddNumbers);
    }
}
