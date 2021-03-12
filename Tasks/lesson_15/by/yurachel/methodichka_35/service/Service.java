package tasks.lesson_15.by.yurachel.methodichka_35.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {

    public static final String FILE_PATH = "resources\\methodichka_35\\BinaryFile.txt";

    public void writeToFile() {
        Random random = new Random();
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_PATH)))) {
            for (int i = 0; i < 15; i++) {
                dos.writeInt(random.nextInt(40));
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }

    private List<Integer> readFromFile() {
        List<Integer> numbers = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_PATH)))) {
            while (dis.available() != 0) {
                numbers.add(dis.readInt());
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return numbers;
    }


    public int average() {
        List<Integer> numbers = readFromFile();
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

}
