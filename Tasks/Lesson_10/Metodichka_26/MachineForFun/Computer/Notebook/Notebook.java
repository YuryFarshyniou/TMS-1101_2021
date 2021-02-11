package Tasks.Lesson_10.Metodichka_26.MachineForFun.Computer.Notebook;

public class Notebook {
    private boolean needCharge;
    private String processor;
    private int amountOfRam;
    private String graphicsCard;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getAmountOfRam() {
        return amountOfRam;
    }

    public void setAmountOfRam(int amountOfRam) {
        this.amountOfRam = amountOfRam;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public boolean isNeedCharge() {
        return needCharge;
    }

    public void setNeedCharge(boolean needCharge) {
        this.needCharge = needCharge;
    }

    public Notebook(String processor, int amountOfRam, String graphicsCard) {
        this.processor = processor;
        this.amountOfRam = amountOfRam;
        this.graphicsCard = graphicsCard;
    }

    void needCharge() {
        if (this.needCharge = true) {
            System.out.println("I am running out off charge.Charge me.");
            this.needCharge = false;
        } else if (this.needCharge = false) {
            System.out.println("I'm already charged.");
            this.needCharge = true;
        }
    }


}
