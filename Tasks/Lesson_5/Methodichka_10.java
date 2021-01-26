package Tasks.Lesson_5;
//Посчитать факториал числа в границах от 10 до 15 (не используя рекурсию).

public class Methodichka_10 {
    public static void main(String[] args) {
        int count = 1;
        for (int i = 10; i < 15; i++) {
            count *= i;
        }
        System.out.println("The factorial is: "+count);
    }
}
