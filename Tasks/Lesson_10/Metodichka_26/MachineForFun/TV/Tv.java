package Tasks.Lesson_10.Metodichka_26.MachineForFun.TV;

public class Tv {
    private String resolution;
    private int portsAmount;
    private int channel;

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getPortsAmount() {
        return portsAmount;
    }

    public void setPortsAmount(int portsAmount) {
        this.portsAmount = portsAmount;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public Tv(String resolution, int portsAmount) {
        this.resolution = resolution;
        this.portsAmount = portsAmount;
    }

    void switchChannelUp() {
        --this.channel;
        System.out.println("Now channel is: " + this.channel);
    }

    void switchChannelDown() {
        ++this.channel;
        System.out.println("Now channel is: " + this.channel);
    }
}
