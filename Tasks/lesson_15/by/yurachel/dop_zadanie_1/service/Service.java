package tasks.lesson_15.by.yurachel.dop_zadanie_1.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {

    public static final String filePathWithInitialWords = "resources\\dop_zadanie_1\\AnyWords.txt";

    public List<String> readWords() {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathWithInitialWords))) {
            String word = "";
            while ((word = reader.readLine()) != null) {
                words.add(word);
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
        return words;
    }

    public void showWords(List<String> list) {
        for (String word : list) {
            System.out.println(word);
        }
    }

    public List<String> findPalindromes(List<String> words) {
        List<String> palindromes = new ArrayList<>();
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

    public void writeToFile(List<String> palindromes) {
        File file = new File("resources\\dop_zadanie_1\\Palindromes.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String word : palindromes) {
                bw.write(word + "\n");
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

}
