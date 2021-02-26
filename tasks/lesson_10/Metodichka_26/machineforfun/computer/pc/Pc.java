package tasks.lesson_10.Metodichka_26.machineforfun.computer.pc;

import tasks.lesson_10.Metodichka_26.machineforfun.computer.Computer;


public class Pc extends Computer {
    private Boolean monitor;
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

    public Pc(String processor, int amountOfRam, String graphicsCard) {
        this.processor = processor;
        this.amountOfRam = amountOfRam;
        this.graphicsCard = graphicsCard;
    }

    public Boolean getMonitor() {
        return monitor;
    }

    public void setMonitor(Boolean monitor) {
        this.monitor = monitor;
    }

    public void TurnOnMonitor() {

        if (this.monitor = false) {
            System.out.println("Turn on the monitor.");
            this.monitor = true;
        } else if (this.monitor = true) {
            System.out.println("Its already on.");
        }

    }

    public void monitorTurnOff() {
        if (this.monitor = true) {
            System.out.println("Turn off the monitor.");
            this.monitor = false;
        } else if (this.monitor = false) {
            System.out.println("Its already off.");
        }
    }


}
