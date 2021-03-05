package tasks.lesson_15.by.yurachel.methodichka_33.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    public static final String FILE_PATH = "resources\\methodicka_33\\FileWithText.txt";

    public int countWords() {
        int wordsCounter = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
            String line = "";

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    wordsCounter++;
                }
            }
        } catch (IOException e) {
            System.err.println("File not found.");
        }
        return wordsCounter;
    }

    public int countPunctuationMarks(){
        int punctuationMarkCounter = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            Pattern pattern = Pattern.compile("[.|,|!|?|:|;]", Pattern.UNICODE_CHARACTER_CLASS);
            String line = "";

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    punctuationMarkCounter++;
                }
            }
        } catch (IOException e) {
            System.err.println("File not found.");
        }
        return punctuationMarkCounter;

    }

}
