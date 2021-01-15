package Tasks;

/* Имеется 4500 секунд. Вывести в консоль содержащихся в этом количестве секунд:
А) минут + секунд. B) часов + минут + секунд.
С) дней + часов + минут + секунд. D) недель + дней + минут + секунд.
 */

public class Task_3 {
    public static void main(String[] args) {
        int s = 4500;
        int sec = s % 60;
        int min = (s - sec) / 60;
        int m = min % 60;
        int hour = (min - m) / 60;
        int h = hour%24;
        int d = (hour-h)/24;
        int day = d%7;
        int week = (d-day)/7;

        System.out.println(min + " минут " + sec + " секунд ");
        System.out.println(hour + " час " + m + " минут " + sec + " секунд ");
        System.out.println( d + " дней " +  h + " час " + m + " минут " + sec + " секунд ");
        System.out.println( week + " недель " + d + " дней " +  h + " час " + m + " минут " + sec + " секунд ");

    }
}
