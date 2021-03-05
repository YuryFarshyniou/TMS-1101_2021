package tasks.lesson_15.by.yurachel.dop_zadanie_4.entity;

import java.io.Serializable;

public class Car implements Serializable {
    private String mark;
    private int price;
    private int speed;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Car(String mark, int price, int speed) {
        this.mark = mark;
        this.price = price;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Mark: " + mark + ", Price: " + price + ", Speed:" + speed;
    }
}
