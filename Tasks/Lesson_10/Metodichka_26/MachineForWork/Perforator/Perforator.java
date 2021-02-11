package Tasks.Lesson_10.Metodichka_26.MachineForWork.Perforator;

import Tasks.Lesson_10.Metodichka_26.MachineForWork.MachineForWork;

public class Perforator extends MachineForWork {
    private int drillSize;


    public int getDrillSize() {
        return drillSize;
    }

    public void setDrillSize(int drillSize) {
        this.drillSize = drillSize;
    }

    public Perforator(int drillSize) {
        this.drillSize = drillSize;
    }

    public void makeHole() {
        System.out.println("Making hole in the wall");
    }

    public void changeDrill() {
        if (switcher) {
            turnOff();
            System.out.println("Changing drill.");
            turnOn();
        } else if (!switcher) {
            System.out.println("Changing drill.");
            turnOn();
        }
    }

}
