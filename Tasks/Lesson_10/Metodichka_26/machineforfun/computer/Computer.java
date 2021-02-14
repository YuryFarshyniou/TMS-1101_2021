package Tasks.Lesson_10.Metodichka_26.machineforfun.computer;

import Tasks.Lesson_10.Metodichka_26.machineforfun.MachineForWatching;

public abstract class Computer extends MachineForWatching {
    String processor;
    int amountOfRam;
    String graphicsCard;

    public void installGame(String gameName) {
        System.out.println("The " + gameName + " is ready to play.");
    }

    public void installIdea() {
        System.out.println("Idea installed.You may start coding.");
    }


}
