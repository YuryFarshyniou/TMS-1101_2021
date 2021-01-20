package Tasks;

/* Определить число,полученное выписыванием в обратном порядке цифр
любого 4-х значного натурального числа n.
 */

import java.io.*;

public class Task_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        int s = (number%10)*1000 +(number/10%10)*100 +(number/100%10)*10 + number/1000%10   ;
        System.out.println(s);



    }
}
