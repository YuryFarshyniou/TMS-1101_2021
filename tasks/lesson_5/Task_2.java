package tasks.lesson_5;

/*Одноклеточная амеба каждые 3 часа делится на 2 клетки.
Определить,сколько амеб будет через 3, 6, 9, 12,..., 24 часа. */

public class Task_2 {
    public static void main(String[] args) {

        int countOfAmoebas = 1;
        System.out.println("Initial number of amoebas " + countOfAmoebas);
        for (int i = 3; i <= 24; i += 3) {
            countOfAmoebas *= 2;
            System.out.println("The amount of ameba in " + i + " hours " + countOfAmoebas);
        }
    }
}
