package Tasks.Lesson_10.Metodichka_25;

public class RunnerAtm {
    public static void main(String[] args) {
        Atm a = new Atm(10,54,30);

        // Добавляем деньги в банкомат.

        a.addCash(43,54,12);
        System.out.println(a);

        // Снимаем деньги с банкомата.

        System.out.println("*******************");
        a.removeCash(9,30,21);

        System.out.println(a);
    }
}
