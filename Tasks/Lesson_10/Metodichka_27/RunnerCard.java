package Tasks.Lesson_10.Metodichka_27;

import Tasks.Lesson_10.Metodichka_27.RealCard.UsuallyPaymentCard.UsuallyPaymentCard;

public class RunnerCard {
    public static void main(String[] args) {
//        VirtualCard v = new VirtualCard("BelarusBank", "International", "Fe123476", 1234_1234, 5000);
//
//        v.addMoney(1234_1234, 100);
//
//        System.out.println(v.amountOfMoney);
//        v.payInLocalOnlineShops("AliExpress", 340);
//        System.out.println(v.amountOfMoney);

        UsuallyPaymentCard p = new UsuallyPaymentCard("Belweb", "Local", "ghgh5", 1234, 5000, false);
        p.payBills(300);
        p.payInLocalShops("Evroopt", 120,false);
        System.out.println(p.amountOfMoney);
    }
}
