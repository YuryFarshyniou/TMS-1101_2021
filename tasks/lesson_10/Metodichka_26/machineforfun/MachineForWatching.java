package tasks.lesson_10.Metodichka_26.machineforfun;

import tasks.lesson_10.Metodichka_26.Machine;

public abstract class MachineForWatching implements Machine {
    public int screenSize;

    public void playMovies(String movieName) {
        System.out.println(movieName + " is playing.");
    }

    @Override
    public void turnOn() {
        System.out.println("Press the button to turn on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Press the button to turn off.");
    }
}
