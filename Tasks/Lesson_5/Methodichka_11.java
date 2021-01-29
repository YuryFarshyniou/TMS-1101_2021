package Tasks.Lesson_5;

/*Имеется целое число, определить является ли это число простым, т.е.
делится без остатка только на 1 и себя.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Methodichka_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number: ");
        int number = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        System.out.println((count > 0) ? number + " - Isn't a simple number." : number + " - Is a simple number.");
    }
}
