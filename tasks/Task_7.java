package tasks;

/* Имеется прямоугольное отверстие размерами a и b,определить,
можно ли его полностью закрыть круглой картонкой радиусом r. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        double r = Double.parseDouble(reader.readLine());
        int squareArea = a * b;
        double circleArea = Math.PI * Math.pow(r, 2);
        System.out.println((squareArea < circleArea) ? "Можно закрыть" : "Нельзя закрыть");

    }
}
