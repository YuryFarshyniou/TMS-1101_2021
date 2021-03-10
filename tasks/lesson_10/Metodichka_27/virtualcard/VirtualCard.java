package tasks.lesson_10.Metodichka_27.virtualcard;

import tasks.lesson_10.Metodichka_27.Card;

public class VirtualCard extends Card {

    // Создаем конструктор.

    public VirtualCard(String bankName, String paymentSystem, String accountNumber, long cardNumber, long amountOfMoney) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.amountOfMoney = amountOfMoney;
        this.paymentSystem = paymentSystem;
    }

    // Оплачиваем покупки в местных онлайн магазинах.

    public void payInLocalOnlineShops(String onlineShopName, int check) {
        if (this.amountOfMoney > check) {
            System.out.println("Pay my purchases in " + onlineShopName);
            this.amountOfMoney -= check;
        } else {
            System.out.println("You need transfer money on your virtual card.");
        }
    }

    // Оплачиваем покупки в международных онлайн магазинах.

    public void payInInternationalOnlineShops(String onlineShopName, int check) {
        if (this.amountOfMoney > check && this.paymentSystem.equals("International")) {
            System.out.println("Pay my purchases in " + onlineShopName);
            this.amountOfMoney -= check;
        } else {
            System.out.println("You need transfer money on your virtual card.");
        }
    }


    // Переводим деньги на карту.

    @Override
    public void addMoney(long virtualCardNumber, long howMuchMoney) {
        if (this.cardNumber == virtualCardNumber) {
            this.amountOfMoney += howMuchMoney;
        } else {
            System.out.println("You enter wrong virtual card number.Try again.");
        }

    }

    // Оплачиваем счета.

    @Override
    public void payBills(int check) {
        if (this.amountOfMoney > check) {
            System.out.println("Paying bills.");
            this.amountOfMoney -= check;
        } else {
            System.out.println("You need transfer money on your virtual card.");
        }
    }
}
