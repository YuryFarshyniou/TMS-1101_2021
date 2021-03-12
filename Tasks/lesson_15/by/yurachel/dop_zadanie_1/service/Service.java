package tasks.lesson_15.by.yurachel.dop_zadanie_1.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {

    public static final String FILE_PATH_WITH_INITIAL_WORDS = "resources\\dop_zadanie_1\\AnyWords.txt";
    public static final String FILE_PATH_WITH_PALINDROMES = "resources\\dop_zadanie_1\\Palindromes.txt";


    private List<String> readWords() {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_WITH_INITIAL_WORDS))) {
            String word = "";
            while ((word = reader.readLine()) != null) {
                words.add(word);
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
        return words;
    }

    private List<String> findPalindromes() {
        List<String> palindromes = new ArrayList<>();
        List<String> words = readWords();
        for (String word : words) {
            StringBuilder ex = new StringBuilder("");
            ex.append(word.toLowerCase());
            ex.reverse();
            if (ex.toString().equalsIgnoreCase(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    public void writeToFile() {
        List<String> palindromes = findPalindromes();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH_WITH_PALINDROMES))) {
            for (String word : palindromes) {
                bw.write(word + "\n");
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

}
