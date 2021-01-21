package Tasks.Lesson3_HomeWork;

/* Треугольник существует только тогда,когда сумма любых двух его сторон больше третьей.Определить,
существует ли такой треугольник.Дано: а,b,c - стороны предполагаемого треугольника.Требуется
сравнить длину каждого отрезка - стороны с суммой двух других.Если хотя бы в одном случае отрезок окажеться
больше суммы дву других,то треугольника с такими сторонами не существует. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson3_Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        if (c > a + b || b > c + a || a > c + b) {
            System.out.println("This triangle doesn't exists");
        } else {
            System.out.println("This triangle exists");
        }

    }
}
