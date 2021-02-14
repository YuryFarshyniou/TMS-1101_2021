package Tasks.Lesson_10.Metodichka_27.realcard.usuallypaymentcard;

import Tasks.Lesson_10.Metodichka_27.realcard.RealCard;

public class UsuallyPaymentCard extends RealCard {

    // Ты возле банкомата или нет.

    boolean nearATM;

    // Создаем конструктор.

    public UsuallyPaymentCard(String bankName, String paymentSystem, String accountNumber, long cardNumber, long amountOfMoney,boolean nearATM) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.amountOfMoney = amountOfMoney;
        this.paymentSystem = paymentSystem;
        this.nearATM = nearATM;
    }

    // Кладем деньги на карту.

    @Override
    public void addMoney(long cardNumber, long howMuchMoney) {
        if (this.cardNumber == cardNumber) {
            this.amountOfMoney += howMuchMoney;
        } else {
            System.out.println("You enter wrong card number.Try again.");
        }
    }

    // Оплачиваем счета.

    @Override
    public void payBills(int check) {
        if (this.amountOfMoney > check && this.nearATM) {
            System.out.println("Paying bills.");
            this.amountOfMoney -= check;
        } else if(this.amountOfMoney < check && this.nearATM ) {
            System.out.println("You need transfer money on your card.");
        }else if(this.amountOfMoney > check && !this.nearATM){
            System.out.println("You need to find ATM to make your operation.");
        }
    }


    // Снимаем деньги с карты.

    public void withdrawMoney(int check) {
        if (this.amountOfMoney > check && this.nearATM) {
            System.out.println("Withdrawing money.");
            this.amountOfMoney -= check;
        } else if(this.amountOfMoney < check && this.nearATM ) {
            System.out.println("You need earn more money.");
        }else if(this.amountOfMoney > check && !this.nearATM){
            System.out.println("You need to find ATM to make your operation.");
        }
    }


}
