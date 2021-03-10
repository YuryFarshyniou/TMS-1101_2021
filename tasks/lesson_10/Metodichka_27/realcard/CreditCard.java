package tasks.lesson_10.Metodichka_27.realcard;

public class CreditCard extends RealCard {
boolean nearBank;

    public CreditCard(String bankName, String paymentSystem, String accountNumber, long cardNumber, long amountOfMoney) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.amountOfMoney = amountOfMoney;
        this.paymentSystem = paymentSystem;
    }


    @Override
    public void addMoney(long cardNumber, long howMuchMoney) {
        if ( nearBank) {
            System.out.println("Add money to your card.");
            this.amountOfMoney += howMuchMoney;
        } else  {
            System.out.println("You need find a bank.");
        }
    }

    @Override
    public void payBills(int check) {
        if (this.amountOfMoney > check && nearBank) {
            System.out.println("Paying bills.");
            this.amountOfMoney -= check;
        } else {
            System.out.println("You need to find a bank.");
        }
    }
}