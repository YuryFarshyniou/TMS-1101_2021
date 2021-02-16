package Tasks.Lesson_10.Metodichka_25;

public class RunnerAtm {
    public static void main(String[] args) {
        Atm a = new Atm(0,0,50);

        // Добавляем деньги в банкомат.

//        a.addCash(2090);
        System.out.println(a);

        // Снимаем деньги с банкомата.

        System.out.println("*******************");


        a.removeCash(2170);

        System.out.println(a);
    }
}
