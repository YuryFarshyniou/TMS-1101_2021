package tasks.robot.src.by.teachmeskills.robot.legs;

public class ToshibaLegs implements ILeg {
    private int price;

    public ToshibaLegs(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Toshiba legs are making move.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
