package tasks.lesson_15.by.yurachel.dop_zadanie_3.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    public static final String TEXT_FILE_PATH = "resources\\dop_zadanie_3\\Text.txt";
    public static final String BLACK_LIST_FILE_PATH = "resources\\dop_zadanie_3\\BlackList.txt";


    public List<String> getSentence() {
        List<String> sentences = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE_PATH))) {
            Pattern pattern = Pattern.compile("[^.!?]+[.!?]");
            StringBuilder stringBuilder = new StringBuilder("");
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            Matcher matcher = pattern.matcher(stringBuilder);
            while (matcher.find()) {
                sentences.add(matcher.group());
            }

        } catch (IOException e) {
            System.err.println("File not found");
        }
        return sentences;
    }

    public List<String> blackList() {
        List<String> blackList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BLACK_LIST_FILE_PATH))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                blackList.add(line);
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
        return blackList;
    }


    public void censored(List<String> sentences, List<String> blackList) {
        Pattern pattern = Pattern.compile("\\w+('\\w+)?");
        boolean isCensorshipOk = true;
        int amountOfSentenceWithoutCensored = 0;
        List<String> sentencesWithoutCensored = new ArrayList<>();

        for (String sentence : sentences) {
            boolean isGoodSentence = true;
            Matcher matcher = pattern.matcher(sentence);
            while (matcher.find()) {
                if (blackList.contains(matcher.group())) {
                    isGoodSentence = false;
                }
            }
            if (!isGoodSentence) {
                isCensorshipOk = false;
                amountOfSentenceWithoutCensored++;
                sentencesWithoutCensored.add(sentence);
            }
        }

        if (!isCensorshipOk) {
            System.out.println("The text wasn't censored. " + "\nAmount of sentences without censored " + amountOfSentenceWithoutCensored + "\n");
            System.out.println("Sentences without censored: ");
            showList(sentencesWithoutCensored);
        } else {
            System.out.println("The text was censored");
        }
    }


    public void showList(List<String> list) {
        for (String sentence : list) {
            System.out.println(sentence);
        }
    }
}
