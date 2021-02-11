package Tasks.Lesson_10.Metodichka_27;

/* Создать иерархию класссов, описывающих банковские карточки.
Иерархия должна иметь хотя бы три уровня. */

public abstract class Card {
    public String bankName;
    public long cardNumber;
    public String accountNumber;
    public long amountOfMoney;
    public String paymentSystem;


    public abstract void addMoney(long cardNumber, long howMuchMoney);

    public abstract void payBills(int check);


}
