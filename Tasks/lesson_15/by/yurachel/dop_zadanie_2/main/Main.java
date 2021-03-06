package tasks.lesson_15.by.yurachel.dop_zadanie_2.main;

import tasks.lesson_15.by.yurachel.dop_zadanie_2.service.TextFormatter;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("resources\\dop_zadanie_2\\FinalText.txt"));
             BufferedReader reader = new BufferedReader(new FileReader("resources\\dop_zadanie_2\\InitialText.txt"))) {

            Pattern pattern = Pattern.compile("([^.!?]+[.!?])", Pattern.UNICODE_CHARACTER_CLASS);
            StringBuilder stringBuilder = new StringBuilder("");
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            System.out.println(stringBuilder);
            Matcher matcher = pattern.matcher(stringBuilder.toString());
            while (matcher.find()) {
                if (TextFormatter.havePalindrome(matcher.group())) {
                    System.out.println("Sentence with palindrome: " + matcher.group());
                    br.write(matcher.group() + "\n");
                } else if (TextFormatter.countWords(matcher.group()) >= 3 && TextFormatter.countWords(matcher.group()) <= 5) {
                    System.out.println("Sentence with amount of words: " + matcher.group());
                    br.write(matcher.group() + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }
}

