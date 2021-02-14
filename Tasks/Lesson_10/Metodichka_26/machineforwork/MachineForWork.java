package Tasks.Lesson_10.Metodichka_26.machineforwork;

import Tasks.Lesson_10.Metodichka_26.Machine;

public abstract class MachineForWork implements Machine {

    public int machineSize;
    public boolean switcher;

    public void turnOn() {

        if (this.switcher)
            System.out.println("Its already working.");
        else if (!this.switcher) {
            System.out.println("Turn up switch up.");
            switcher = true;
        }
    }

    @Override
    public void turnOff() {
        if (this.switcher = false)
            System.out.println("Its not working.");
        else if (this.switcher = true) {
            System.out.println("Turn up switch down.");
            switcher = false;
        }
    }
}
