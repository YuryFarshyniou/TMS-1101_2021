package Tasks;

/* Имеется целое число(задать с помощью Random rand = new Random();
int x = rand.nextInt().Это число - количестве денег в рублях.Вывести это число,добавив
к нему слово рублей в правильном падеже.
 */

import java.util.Random;

public class Task_8 {
    public static void main(String[] args) {
        int x = new Random().nextInt(1560);
        int z = x % 10, y = x % 100;
        if ((z == 0 || z == 5 || z == 6 || z == 7 || z == 8 || z == 9 || y == 14 || y == 13 || y == 11 || y == 12)) {
            System.out.println("У нас на кармане сейчас: " + x + " рублей");
        } else if (z == 1) {
            System.out.println("У нас на кармане сейчас: " + x + " рубль");
        } else {
            System.out.println("У нас на кармане сейчас: " + x + " рубля");
        }
    }
}
