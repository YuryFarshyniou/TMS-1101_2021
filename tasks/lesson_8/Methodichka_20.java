package tasks.lesson_8;

/*Имеется строка с текстом. Вывести текст, составленный из последних букв
всех слов. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methodichka_20 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any string: ");
        String anyString = reader.readLine();
        String regex = "\\w\\b";
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(regex,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(anyString);
        while (matcher.find()) {
            stringBuilder.append(matcher.group());
        }

        System.out.println(stringBuilder);
    }
}
