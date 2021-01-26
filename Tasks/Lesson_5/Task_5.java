package Tasks.Lesson_5;

//Напишите программу вывода всех четных чисел от 2 до 100 включительно

public class Task_5 {
    public static void main(String[] args) {

        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
