package tasks.lesson_13.by.yurachel.methodichka_32.main;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> dictionary = new HashMap<>();

        String text = "Частотный словарь (или частотный список) — набор слов данного языка (или подъязыка) вместе с информацией" +
                " о частоте их встречаемости. Словарь может быть отсортирован по частоте," +
                " по алфавиту (тогда для каждого слова будет указана его частота)," +
                " по группам слов (например, первая тысяча наиболее частотных слов," +
                " за ней вторая и т. п.), по типичности (слова, частотные для большинства текстов)," +
                " и т. д. Частотные списки используются для преподавания языка," +
                " создания новых словарей, приложений компьютерной лингвистики, исследований в области лингвистической типологии, и т. д.";

        String regex = "\\w+";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (!dictionary.containsKey(matcher.group())) {
                dictionary.put(matcher.group(), 1);
            } else {
                int count = dictionary.get(matcher.group());
                dictionary.put(matcher.group(), ++count);
            }
        }

        for (Map.Entry entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
