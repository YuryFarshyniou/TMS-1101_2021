package tasks.robot.src.by.teachmeskills.robot;

/*        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */

import tasks.robot.src.by.teachmeskills.robot.hands.SamsungHand;
import tasks.robot.src.by.teachmeskills.robot.hands.SonyHand;
import tasks.robot.src.by.teachmeskills.robot.hands.ToshibaHand;
import tasks.robot.src.by.teachmeskills.robot.heads.SamsungHead;
import tasks.robot.src.by.teachmeskills.robot.heads.SonyHead;
import tasks.robot.src.by.teachmeskills.robot.heads.ToshibaHead;
import tasks.robot.src.by.teachmeskills.robot.legs.SamsungLegs;
import tasks.robot.src.by.teachmeskills.robot.legs.SonyLegs;
import tasks.robot.src.by.teachmeskills.robot.legs.ToshibaLegs;

public class Run {
    public static void main(String[] args) {

        Robot firstRobot = new Robot(new SamsungHead(650), new ToshibaHand(123), new SonyLegs(400));
        firstRobot.action();
        System.out.println("First robot price is: " + firstRobot.getPrice() + "$.");

        Robot secondRobot = new Robot(new ToshibaHead(420),new SonyHand(500),new SamsungLegs(800));
        secondRobot.action();
        System.out.println("Second robot price is: " + secondRobot.getPrice() + "$.");

        Robot thirdRobot = new Robot(new SonyHead(535),new SamsungHand(320),new ToshibaLegs(617));
        thirdRobot.action();
        System.out.println("Third robot price is: " + thirdRobot.getPrice() + "$.");


    }
}
