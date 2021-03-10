package tasks.lesson3_home_work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* В переменную записываем число.Надо вывести на экран сколько в этом числе цифр и положительное оно,
или отрицательное.Например,"это однозначное положительное число".Достаточно будет определить,является
ли число однозначным,"двузначным или трехзначным и более".

 */
public class Lesson3_Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        if (number == 0) {
            System.out.println("Число равно 0");
        } else if (number == Integer.MAX_VALUE || number == Integer.MIN_VALUE) {
            System.out.println("You have reached max or min value of Integer! Congratulation!!!");
        } else {
            int divided = 10;
            int count = 1;
            while (true) {
                int number2 = number % divided;
                if (number2 == number) break;
                count++;
                divided *= 10;
            }
            switch (count) {
                case 1:
                    if (number > 0) {
                        System.out.println("это однозначное положительное число ");
                    } else {
                        System.out.println("это однозначное отрицательное число");
                    }
                    break;
                case 2:
                    if (number > 0) {
                        System.out.println("это двузначное положительное число ");
                    } else {
                        System.out.println("это двузначное отрицательное число");
                    }
                    break;
                case 3:
                    if (number > 0) {
                        System.out.println("это трехзначное положительное число ");
                    } else {
                        System.out.println("это трехзначное отрицательное число");
                    }
                    break;
                case 4:
                    if (number > 0) {
                        System.out.println("это четырехзначное положительное число ");
                    } else {
                        System.out.println("это четырехзначное отрицательное число");
                    }
                    break;
                case 5:
                    if (number > 0) {
                        System.out.println("это пятизначное положительное число ");
                    } else {
                        System.out.println("это пятизначное отрицательное число");
                    }
                    break;
                case 6:
                    if (number > 0) {
                        System.out.println("это шестизначное положительное число ");
                    } else {
                        System.out.println("это шестизначное отрицательное число");
                    }
                    break;
                case 7:
                    if (number > 0) {
                        System.out.println("это семизначное положительное число ");
                    } else {
                        System.out.println("это семизначное отрицательное число");
                    }
                    break;
                case 8:
                    if (number > 0) {
                        System.out.println("это восьмизначное положительное число ");
                    } else {
                        System.out.println("это восьмизначное отрицательное число");
                    }
                    break;
                case 9:
                    if (number > 0) {
                        System.out.println("это девятизначное положительное число ");
                    } else {
                        System.out.println("это девятизначное отрицательное число");
                    }
                    break;

            }



        }

    }
}
