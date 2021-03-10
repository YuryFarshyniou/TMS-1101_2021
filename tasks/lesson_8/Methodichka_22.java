package tasks.lesson_8;

/* Написать программу, выполняющую поиск в строке шестнадцатеричных чисел,
записаных по правилам Java, с помощью регулярных выражений и вывести их на
страницу. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methodichka_22 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any string: ");
        String anyString = reader.readLine();
        String regex = "0[Xx]\\d*[A-Fa-f]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(anyString);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
