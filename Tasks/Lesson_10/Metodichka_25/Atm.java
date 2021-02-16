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
    private int amountOfMoneyInAtm;

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
        this.amountOfMoneyInAtm = this.numberOfTwenty * 20 + this.numberOfFifty * 50 + this.numberOfHundred * 100;
    }

    // Добавляем деньги в банкомат.

    void addCash(int sumToAdd) {
        System.out.println("Amount of money in ATM: " + this.amountOfMoneyInAtm);
        if (sumToAdd < 0) {
            System.out.println("Wrong number.");
        } else {
            int hundreds = sumToAdd / 100;
            int fifties = (sumToAdd - hundreds * 100) / 50;
            int twenties = (sumToAdd - (hundreds * 100 + fifties * 50)) / 20;
            int sumOfCash = hundreds * 100 + fifties * 50 + twenties * 20;
            int difference = sumToAdd - sumOfCash;
            this.numberOfHundred += hundreds;
            this.numberOfFifty += fifties;
            this.numberOfTwenty += twenties;
            if (sumOfCash == sumToAdd) {
                System.out.println("We added all money.");
                System.out.println("We added " + twenties + " twenty, " + fifties + " fifty, " + hundreds + " hundred.");
            } else if (sumOfCash < sumToAdd) {
                System.out.println("We have no added " + difference + "$, because we don't have bills for these money.");
                if (hundreds != 0 || fifties != 0 || twenties != 0) {
                    System.out.println("We added " + twenties + " twenty, " + fifties + " fifty, " + hundreds + " hundred.");
                } else {
                    System.out.println("We added nothing.");
                }
            }
            this.amountOfMoneyInAtm += sumOfCash;
            System.out.println("Amount of money in ATM: " + this.amountOfMoneyInAtm);
        }
    }

    // Снимаем деньги с банкомата.

    void removeCash(int sumToWithDraw) {
        System.out.println("Amount of money in ATM: " + this.amountOfMoneyInAtm);
        if (sumToWithDraw < 0) {
            System.out.println("Wrong number.");
        } else if (this.amountOfMoneyInAtm < sumToWithDraw) {
            System.out.println("ATM doesn't have enough money to withdraw.");

            // Подсчет.

        } else {

            // Если купюр 100 в банкомате меньше чем мы хотим снять.

            int allHundred = 0;
            int hundred = 0;
            int hundreds = sumToWithDraw / 100;
            if (this.numberOfHundred < hundreds) {
                hundreds -= this.numberOfHundred;
                allHundred = sumToWithDraw / 100 - hundreds;
                this.numberOfHundred = 0;
            } else if (this.numberOfHundred > hundreds) {
                hundred = hundreds;
                this.numberOfHundred -= hundreds;
            } else {
                hundred = hundreds;
                this.numberOfFifty = 0;
            }


            // Если купюр 50 в банкомате меньше, чем мы хотим снять.

            int allFifties = 0;
            int fifty = 0;
            int fifties = (sumToWithDraw - hundred * 100) / 50;
            if (this.numberOfFifty < fifties) {
                fifties -= this.numberOfFifty;
                allFifties = (sumToWithDraw - hundred * 100) / 50 - fifties;
                this.numberOfFifty = 0;
            } else if (this.numberOfFifty > fifties) {
                fifty = fifties;
                this.numberOfFifty -= fifties;
            } else {
                fifty = fifties;
                this.numberOfFifty = 0;
            }

            // Если купюр 20 в банкомате меньше, чем мы хотим снять.

            int twenty = 0;
            int allTwenties = 0;
            int twenties = (sumToWithDraw - (hundred * 100 + fifty * 50)) / 20;
            if (this.numberOfTwenty < twenties) {
                twenties -= this.numberOfTwenty;
                allTwenties = ((sumToWithDraw - (hundred * 100 + fifty * 50)) / 20) - twenties;
                this.numberOfTwenty = 0;
            } else if (this.numberOfTwenty > twenties) {
                twenty = twenties;
                this.numberOfTwenty -= twenties;
            } else {
                twenty = twenties;
                this.numberOfTwenty = 0;
            }

            int sumOfCash = hundred * 100 + fifty * 50 + twenty * 20;
            int difference = sumToWithDraw - sumOfCash;

            // Выводим результаты.

            if (sumOfCash == sumToWithDraw) {
                System.out.println("We withdrew all the money.");
                System.out.println("We withdrew " + twenty + " twenty, " + fifty + " fifty, " + hundred + " hundred.");
            } else if (sumOfCash < sumToWithDraw) {

                System.out.println("We have no withdrew " + difference + "$, because we don't have bills for these money.");
                if (hundreds != 0 || fifties != 0 || twenties != 0) {
                    System.out.println("We withdrew " + twenty + " twenty, " + fifty + " fifty, " + hundred + " hundred.");
                } else {
                    System.out.println("We withdrew nothing.");
                }
            }
            this.amountOfMoneyInAtm -= sumOfCash;
            System.out.println("Amount of money in ATM: " + this.amountOfMoneyInAtm);
        }
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
