package tasks.lesson_15.by.yurachel.dop_zadanie_2.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormatter {


    public static int countWords(String line) {
        int wordsCounter = 0;
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            wordsCounter++;
        }
        return wordsCounter;
    }

    public static boolean havePalindrome(String line) {
        boolean isPalindrome = false;
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            StringBuilder palindrome = new StringBuilder("");
            palindrome.append(matcher.group().toLowerCase());
            palindrome.reverse();
            if (palindrome.toString().equalsIgnoreCase(matcher.group()) && matcher.group().length() > 1) {
                System.out.println("Palindrome: " + matcher.group());
                isPalindrome = true;
            }
        }
        return isPalindrome;
    }


}
