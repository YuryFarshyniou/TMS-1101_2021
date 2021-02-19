package Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.logic;

import Tasks.lesson_11.task_from_blinov_payment.by.yurachel.payment_task.entity.Payment;

import java.util.List;
import java.util.Map;

public class Purchases {

    // Поддерживает ли магазин банк клиента.

    public void isSupportingBank(List<String> list, Payment payment) {
        for (String name : list) {
            if (payment.getCustomer().getBankName().equalsIgnoreCase(name)) {
                payment.setOk(true);
            }
        }
    }

    // Добавляем покупки

    public void addPurchase(Map<String,Integer>prices,String purchaseName, int purchasePrice) {
        prices.put(purchaseName, purchasePrice);
    }

    // Общая сумма покупок.

    public int sumOfPurchase(Map<String, Integer> priceList) {
        int sum = 0;
        for (Map.Entry entry : priceList.entrySet()) {
            sum += (int) entry.getValue();
        }
        return sum;
    }

    // Оплачиваем покупки.

    public void payment(Payment payment, Map<String, Integer> priceList) {
        if (payment.isOk() && payment.getCustomer().isAvailable() && payment.getCustomer().getAmountOfMoney() > sumOfPurchase(priceList)) {
            payment.getCustomer().setAmountOfMoney(payment.getCustomer().getAmountOfMoney() - sumOfPurchase(priceList));
            System.out.println("Payment success.");
        } else if (!payment.isOk() && payment.getCustomer().isAvailable() && payment.getCustomer().getAmountOfMoney() > sumOfPurchase(priceList)) {
            System.out.println("We not accept this bank's cards.We're sorry.");
        } else if (payment.isOk() && !payment.getCustomer().isAvailable() && payment.getCustomer().getAmountOfMoney() > sumOfPurchase(priceList)) {
            System.out.println("Customer's card blocked.");
        } else if (payment.isOk() && payment.getCustomer().isAvailable() && payment.getCustomer().getAmountOfMoney() < sumOfPurchase(priceList)) {
            System.out.println("There are not enough money at the card");
        }
    }

    // Добавляем новый банк .

    public void addBank(List<String> banksList, String bankName) {
        banksList.add(bankName);
    }
}
