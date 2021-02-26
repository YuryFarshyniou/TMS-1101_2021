package tasks.lesson_8;

/* Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у
которых есть параметры, например <p id=”p1”>, и замену их на простые теги
абзацев <p>. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Methodochka_23 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any string: ");
        String anyString = reader.readLine();
        String regex = "<\\/?p.*?>";
        anyString = anyString.replaceAll(regex, "<p>");
        System.out.println(anyString);
    }
}
