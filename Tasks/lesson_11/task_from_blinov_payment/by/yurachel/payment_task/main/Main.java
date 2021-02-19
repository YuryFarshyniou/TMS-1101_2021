package Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.main;


import Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.entity.Payment;
import Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.logic.Purchases;

public class Main {
    public static void main(String[] args) {

        Payment p = new Payment();
        Purchases pur = new Purchases();

        p.setCustomer(p.new Customer("AlfaBank", 56781234, true, 5000)); // Новый клиент.

        pur.isSupportingBank(p.getBanks(), p); // Может ли клиент оплатить своей картой.

        pur.addPurchase(p.getPrices(), "PS5", 700);  // Добавляет в корзину покупки.
        pur.addPurchase(p.getPrices(), "Sofa", 300);

        pur.payment(p, p.getPrices());  // Оплачиваем.

    }

}
