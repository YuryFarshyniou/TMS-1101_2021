package tasks.lesson_5;

/* Начав тренировки, спортсмен в первый день пробежал 10 км. Каждыйдень он увеличивал дневную норму на 10% нормы предыдущего дня.
 Какой суммарный путь пробежит спортсмен за 7 дней? */

public class Task_1 {
    public static void main(String[] args) {
        double distance = 10;
        double sumOfKm = 0;
        for (int i = 0; i < 7; i++) {
            sumOfKm += distance;
            distance = distance + (distance * 0.1);
        }
        System.out.println("The sum of km for 7 days: " + (int) sumOfKm);
    }
}
