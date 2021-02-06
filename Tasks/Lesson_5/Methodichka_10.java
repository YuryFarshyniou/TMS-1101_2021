package Tasks.Lesson_5;
//Посчитать факториал числа в границах от 10 до 15 (не используя рекурсию).

public class Methodichka_10 {
    public static void main(String[] args) {
        int number = 10;

        while (number < 16) {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("The factorial of number " + number + " is " + factorial);
            number++;
        }
    }
}
