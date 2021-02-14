package Tasks.Lesson_10.Metodichka_27.realcard;

import Tasks.Lesson_10.Metodichka_27.Card;

public abstract class RealCard extends Card {

    // Размеры карты.

    public static final double cardWidth = 85.595;
    public static final double cardHeight = 53.975;
    public static final double cardThickness = 0.76;

    // Оплачиваем покупки.

    public void payInLocalShops(String shopName, int check, boolean haveATerminal) {
        if (this.amountOfMoney > check && haveATerminal) {
            System.out.println("Pay my purchases in " + shopName);
            this.amountOfMoney -= check;
        } else if (this.amountOfMoney < check && haveATerminal) {
            System.out.println("You need earn more  money.");
        } else if (this.amountOfMoney > check && !haveATerminal) {
            System.out.println("We cannot serve you.We don't have a terminal.");
        }
    }

    // Покупаем топливо.

    public void payOnGasStation(int check, boolean haveATerminal) {
        if (this.amountOfMoney > check && haveATerminal) {
            System.out.println("Pay gas on gas station");
            this.amountOfMoney -= check;
        } else if (this.amountOfMoney < check && haveATerminal) {
            System.out.println("You need earn more  money.");
        } else if (this.amountOfMoney > check && !haveATerminal) {
            System.out.println("We cannot serve you.We don't have a terminal.");
        }
    }
}
