package tasks.lesson_15.by.yurachel.dop_zadanie_2.main;

import tasks.lesson_15.by.yurachel.dop_zadanie_2.service.TextFormatter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<String> initialText = initialTextToList();
        try (BufferedWriter br = new BufferedWriter(new FileWriter("resources\\dop_zadanie_2\\FinalText.txt"))) {
            for (String sentence : initialText) {
                if (TextFormatter.havePalindrome(sentence)) {
                    System.out.println("Sentence with palindrome: " + sentence);
                    br.write(sentence + "\n");
                } else if (TextFormatter.countWords(sentence) >= 3 && TextFormatter.countWords(sentence) <= 5) {
                    System.out.println("Sentence with amount of words: " + sentence);
                    br.write(sentence + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }


    public static List<String> initialTextToList() {
        List<String> initialText = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("resources\\dop_zadanie_2\\InitialText.txt"))) {
            Pattern pattern = Pattern.compile("([^.!?]+[.!?])");
            String line = "";
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    initialText.add(matcher.group());
                }
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
        return initialText;
    }


    public static void showList(List<String> list) {
        for (String words : list) {
            System.out.println(words);
        }
    }
}
