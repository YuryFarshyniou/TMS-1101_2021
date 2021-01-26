package Tasks.Lesson_5;

/*Изменить пример с суммой чисел таким образом, чтобы рассчитывалась не сумма, а
произведение, т.е. факториал числа.*/

public class Methodichka_9 {
    public static void main(String[] args) {
        double averageMult = 0;
        double multiplication = 1;
        int n = 0;
        int x = (int) (Math.random() * 20);
        while (x != 0) {
            multiplication *= x;
            n++;
            x = (int) (Math.random() * 20);
        }
        if (n != 0) {
            averageMult = multiplication / n;
        } else {
            averageMult = 0;
        }
        System.out.println("The result of the multiplications: " + multiplication);
        System.out.println("The number of iterations: " + n);
        System.out.print("Average: ");
        System.out.printf("%.2f", averageMult);
    }
}
