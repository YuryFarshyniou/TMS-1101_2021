package Tasks.Lesson3_HomeWork;

/* Дано целое число.Если оно является положительным,то прибавить к нему 1.Если отрицательным,
то вычесть из него 2.Если нулевым,то заменить его на 10.Вывести полученное число.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson3_Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        if (number > 0) {
            number++;
        } else if (number < 0) {
            number -= 2;
        } else {
            number = 10;
        }
        System.out.println(number);
    }
}
