package Tasks.Lesson_5;

/* Напишите программу печати таблицы перевода расстояний из дюймов в сантиметры
 для значений длин от 1 до 20 дюймов. 1 дюйм = 2,54 см. */

public class Task_4 {
    public static void main(String[] args) {
        float inchToSm = 0f;
        System.out.print("The table is: ");
        System.out.println(" ");
        for (int i = 0; i < 20; i++) {
            inchToSm += 2.54;
            System.out.print(i + 1 + " sm is equals ");
            System.out.printf("%.2f", inchToSm);
            System.out.println(" inches ");
        }
    }
}
