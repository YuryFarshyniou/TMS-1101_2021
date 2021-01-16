package Tasks;

/* Определить число,полученное выписыванием в обратном порядке цифр
любого 4-х значного натурального числа n.
 */

import java.io.*;

public class Task_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[4];
        int number = Integer.parseInt(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            int n = (number % 10);
            arr[i] = n;
            number /= 10;

        }
        for (int num :
                arr) {
            System.out.print(num);
        }
    }
}
