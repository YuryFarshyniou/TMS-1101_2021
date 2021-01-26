package Tasks.Lesson_5;


/*Создать массив оценок произвольной длины, вывести максимальную и
минимальную оценку, её (их) номера. */


import java.util.Arrays;
import java.util.Random;

public class Methodichka_14 {
    public static void main(String[] args) {
Random rand = new Random();
int [] array = new int[rand.nextInt(9)+2];
int max=0;
int maxIndex = 0;
int min=10;
int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            array[i]=rand.nextInt(10);

            if(array[i]>max){
                max=array[i];
                maxIndex = i;
            }
            if(array[i]<=min){
                min = array[i];
                minIndex = i;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Max grade is: " + max + " and it's index is: " + maxIndex);
        System.out.println("Min grade is: " + min + " and it's index is: " + minIndex);

    }
}
