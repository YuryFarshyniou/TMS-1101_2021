package tasks.robot.src.by.teachmeskills.robot.legs;

public class SonyLegs implements ILeg {
    private int price;

    public SonyLegs(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Sony legs are making move.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
