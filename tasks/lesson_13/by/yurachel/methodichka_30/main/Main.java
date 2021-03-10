package tasks.lesson_13.by.yurachel.methodichka_30.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(rand.nextInt(20));
        }
        System.out.println(list);

        System.out.println("********************");

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == list.get(i)) {
                    count++;
                }
            }
            if (count > 1) list.remove(i);
        }
        System.out.println(list);

    }
}
