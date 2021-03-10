package tasks.lesson3_home_work;

/*В переменную записываете количество программистов.
В зависимости от количества программистов необходимо вывести правильно окончание.
 Например: • 2 программиста • 1 программиста • 10 программистов • и т.д.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Lesson3_Task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Сколько у вас сейчас в офисе находится программистов? ");
        int x = Integer.parseInt(reader.readLine());
        int z = x % 10, y = x % 100;
        if ((z == 0 || z == 5 || z == 6 || z == 7 || z == 8 || z == 9 || y == 14 || y == 13 || y == 11 || y == 12)) {
            System.out.println("Сейчас у нас в офисе: " + x + " программистов");
        } else if (z == 1) {
            System.out.println("Сейчас у нас в офисе: " + x + " программист");
        } else {
            System.out.println("Сейчас у нас в офисе: " + x + " программиста");
        }

    }
}
