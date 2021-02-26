package tasks.lesson_10.Metodichka_26;

/* Создать иерархию классов, описывающих бытовую технику.Создать несколько
объектов описанных классов,часть из них включить в розетку.Иерархия должна
иметь хотя бы три уровня. */


public interface Machine {
    void turnOn();

    void turnOff();

    default void plugIn() {
        System.out.println("Plug into an outlet");
    }

    default void plugOut() {
        System.out.println("Unplug");
    }
}
