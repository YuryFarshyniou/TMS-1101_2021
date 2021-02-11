package Tasks.Lesson_10.Metodichka_25;

/* Создать класс и объекты описывающие Банкомат. Набор купюр находящихся в
банкомате должен задаваться тремя свойствами: количеством купюр номиналом 20,
50,100. Сделать методы для добавления денег в банкомат. Сделать функцию снимающую деньги.
На вход передается сумма денег. На выход - булевское значение(операция удалась или нет). При
снятии денег фунция должна распечатывать каким количством купюр какого номинала выдается сумма.
Создать конструктор с тремя параметрами  - количеством купюр. */

public class Atm {
    private int numberOfTwenty;
    private int numberOfFifty;
    private int numberOfHundred;

    public int getNumberOfTwenty() {
        return numberOfTwenty;
    }

    public void setNumberOfTwenty(int numberOfTwenty) {
        this.numberOfTwenty = numberOfTwenty;
    }

    public int getNumberOfFifty() {
        return numberOfFifty;
    }

    public void setNumberOfFifty(int numberOfFifty) {
        this.numberOfFifty = numberOfFifty;
    }

    public int getNumberOfHundred() {
        return numberOfHundred;
    }

    public void setNumberOfHundred(int numberOfHundred) {
        this.numberOfHundred = numberOfHundred;
    }

    public Atm(int amountOfTwenties, int amountOfFifties, int amountOfHundreds) {
        this.numberOfTwenty = amountOfTwenties;
        this.numberOfFifty = amountOfFifties;
        this.numberOfHundred = amountOfHundreds;
    }

    // Добавляем деньги в банкомат.

    void addCash(int twenty, int fifty, int hundreds) {
        this.numberOfTwenty += twenty;
        this.numberOfFifty += fifty;
        this.numberOfHundred += hundreds;

    }

    // Снимаем деньги с банкомата.

    void removeCash(int twenty, int fifty, int hundreds) {

        System.out.println("In ATM now " + this.numberOfTwenty + " twenty, " + this.numberOfFifty + " fifty, " +
                this.numberOfHundred + " hundred.");

        boolean completed = true;

        this.numberOfTwenty -= twenty;
        if (this.numberOfTwenty < 0) {
            this.numberOfTwenty = 0;
            completed = false;
        }

        this.numberOfFifty -= fifty;
        if (this.numberOfFifty < 0) {
            this.numberOfFifty = 0;
            completed = false;
        }

        this.numberOfHundred -= hundreds;
        if (this.numberOfHundred < 0) {
            this.numberOfHundred = 0;
            completed = false;

        }

        System.out.println("We took of " + twenty + " twenty, " + fifty + " fifty, " +
                hundreds + " hundred.");

        System.out.println("In ATM after took of: " + this.numberOfTwenty + " twenty, " + this.numberOfFifty + " fifty, " +
                this.numberOfHundred + " hundred.");

        System.out.println("Is completed your operation? " + completed);
        if (!completed) System.out.println("Need to add more cash in ATM.");

    }

    // Выводим текущее количество купюр в банкомате.

    @Override
    public String toString() {
        return "Atm{" +
                "numberOfTwenty=" + numberOfTwenty +
                ", numberOfFifty=" + numberOfFifty +
                ", numberOfHundred=" + numberOfHundred +
                '}';
    }
}
