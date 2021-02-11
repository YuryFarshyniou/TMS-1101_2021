package Tasks.Lesson_10.Metodichka_24;

/* Создать класс и объекты, описывающие промежуток времени. Сам промежуток
в классе должен задаваться тремя свойствами: секундами, минутами, часами.
Сделать методы для получения полного количества секунд в объекте, сравнения
двуъ объектов( метод должен работать аналогично compareTo в строках). Создать
два конструктора: получающий общее количество секунд, и часы,минуты и секунды по
отдельности.Сделать метод для вывода данных.

 */

public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    int m;
    int h;

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    // Конструктор для часов,минут ,секунд.

    public Time(int seconds, int minutes, int hours) {
        this.seconds = seconds;
        if (seconds >= 60) {
            m = seconds / 60;
            this.seconds = seconds % 60;
        }

        this.minutes = minutes + m;
        if (this.minutes >= 60) {
            h = this.minutes / 60;
            this.minutes %= 60;
        }
        this.hours = hours + h;
    }

    // Конструктор для секунд.

    public Time(int seconds) {
        this.seconds = seconds;
    }

    // Переопределяем метод toString.Выводим объекты.

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }

    // Узнаем количество секунд в объекте.

    int amountOfSeconds() {
        return getSeconds() + getMinutes() * 60 + getHours() * 3600;
    }


    // Сравниваем объекты.

    void compareTo(Time a) {
        if (this.amountOfSeconds() > a.amountOfSeconds()) {
            System.out.println(this + " is Bigger!!!");
        } else if (this.amountOfSeconds() < a.amountOfSeconds()) {
            System.out.println(a + " is Bigger!!");
        } else {
            System.out.println("Its equals.");
        }

    }
}
