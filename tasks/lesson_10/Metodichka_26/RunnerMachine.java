package tasks.lesson_10.Metodichka_26;

import tasks.lesson_10.Metodichka_26.machineforwork.grinder.Grinder;

public class RunnerMachine {
    public static void main(String[] args) {
        Grinder g = new Grinder(125);
        g.switcher = false;
        g.turnOn();
        g.grinderCuts();
        g.changeGrinderWheel();
        g.grinderCuts();
    }
}
