package Tasks;

/* Определить число,полученное выписыванием в обратном порядке цифр
любого 4-х значного натурального числа n.
 */

import java.io.*;

public class Task_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        System.out.println("The new number is: " + number%10 + number/10%10 + number/100%10 + number/1000%10);

    }
}
