package tasks.lesson_8;

/* Найти в строке не только запятые, но и другие знаки препинания. Подсчитать
общее их количество. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methodichka_18 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any string: ");
        String anyString = reader.readLine();
        String regex = "[,.!?;:()\\[\\]{}&]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(anyString);
        int punctMarkscount = 0;
        while (matcher.find()) {
            punctMarkscount++;
        }
        System.out.println("The amount of our punctuation marks: " + punctMarkscount);
    }
}
