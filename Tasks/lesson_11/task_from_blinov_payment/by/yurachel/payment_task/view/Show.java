package Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.view;

import java.util.Map;

public class Show {

    // Выводим список покупок.

    public void showPurchases(Map<String, Integer> purchaseList) {
        for (Map.Entry entry : purchaseList.entrySet()) {
            System.out.println("Purchase " + entry.getKey() + " and it's price if " + entry.getValue());
        }
    }
}
