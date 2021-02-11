package Tasks.Lesson_10.Metodichka_24;

public class TimeRunner {
    public static void main(String[] args) {

        // Сравниваем объекты.

        Time t = new Time(121, 78, 10);
        Time t2 = new Time(12, 43, 16);
        t.compareTo(t2);

        // Узнаем количество секунд в объектах.

        Time secondTime = new Time(3800);
        t.amountOfSeconds();
        secondTime.amountOfSeconds();


    }
}
