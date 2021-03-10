package tasks.robot.src.by.teachmeskills.robot.legs;

public class SamsungLegs implements ILeg {
    private int price;

    public SamsungLegs(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Samsung legs are making move.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
