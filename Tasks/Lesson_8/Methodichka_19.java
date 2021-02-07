package Tasks.Lesson_8;

/* Имеется строка с текстом. Подсчитать количество слов в тексте. Желательно
учесть, что слова могут разделяться несколькими пробелами, в начале и конце
текста также могут быть пробелы, но могут и отсутствовать. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methodichka_19 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any string: ");
        String anyString = reader.readLine();
        String regex = "\\w+";
        Pattern pattern = Pattern.compile(regex,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(anyString);
        int wordsCount = 0;
        while (matcher.find()) {
            wordsCount++;
        }

        System.out.println("The amount of words in our string: " + wordsCount);
    }
}
