package Tasks;

//Дано любое натуральное 4-х значное число.Верно ли,что все цифры числа различны.


import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();

        char[] arr = number.toCharArray();

        boolean numbers = true;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count >= 2) {
                System.out.println("Цифры не различны");
                numbers = false;
                break;
            }
        }
        if (numbers) System.out.println("Все цифры разные");

    }
}
