package Tasks.lesson_11.taskFromBlinov_Payment;


public class RunnerPayment {
    public static void main(String[] args) {

        Payment pay = new Payment(new int[]{345, 10, 26}); // Цены на товары.
        pay.setCustomer(pay.new Customer("BelGazPromBank", 45671234, true, 5000)); // Создаем клиента.
        pay.isSupportingBank();
        System.out.println(pay.isOk());
        System.out.println(pay.sumOfPurchase());
        pay.payment();
        System.out.println(pay.getCustomer().getAmountOfMoney());
    }

}
