package Tasks.Lesson_10.Metodichka_26.machineforwork.grinder;

import Tasks.Lesson_10.Metodichka_26.machineforwork.MachineForWork;

public class Grinder extends MachineForWork {
    private int grinderWheel;

    public int getGrinderWheel() {
        return grinderWheel;
    }

    public void setGrinderWheel(int grinderWheel) {
        this.grinderWheel = grinderWheel;
    }

    public Grinder(int grinderWheel) {
        this.grinderWheel = grinderWheel;
    }

    public void grinderCuts() {
        System.out.println("Grinder cuts.");
    }

    public void changeGrinderWheel() {
        if (switcher) {

            turnOff();
            System.out.println("Changing grinder wheel.");
            turnOn();
        } else if (!switcher) {
            System.out.println("Changing grinder wheel.");
            turnOn();
        }
    }
}
