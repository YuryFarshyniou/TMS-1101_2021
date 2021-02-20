package Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.main;


import Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.entity.Payment;
import Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.logic.Purchases;
import Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.view.Show;

public class Main {
    public static void main(String[] args) throws Exception {

        Payment p = new Payment();
        Purchases pur = new Purchases();
        Show show = new Show();

        p.setCustomer(p.new Customer("AlfaBank", 56781234, true, 5000)); // Новый клиент.

        pur.isSupportingBank(p.getBanks(), p); // Может ли клиент оплатить своей картой.

        pur.addPurchase(p.getPurchaseMap(), "PS5", 700);  // Добавляет в корзину покупки.
        pur.addPurchase(p.getPurchaseMap(), "Sofa", 300);

        pur.payment(p, p.getPurchaseMap());  // Оплачиваем.
        show.showPurchases(p.getPurchaseMap());

    }

}
