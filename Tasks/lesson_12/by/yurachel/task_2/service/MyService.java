package Tasks.lesson_12.by.yurachel.task_2.service;

import Tasks.lesson_12.by.yurachel.task_2.annotation.Version;

import java.util.Objects;

@Version(version = 1.0)
public class MyService {
    private String name;
    private String field;
    private int amount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public MyService(String name, String field, int amount) {
        this.name = name;
        this.field = field;
        this.amount = amount;
    }

    private void thisClassInfo() {
        System.out.println("Information about our ClassService: " + this.name + " " + this.field + " " + this.amount);
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyService myService1 = (MyService) o;
        return this.amount == myService1.amount && Objects.equals(this.name, myService1.name) && Objects.equals(this.field, myService1.field);
    }


    public int hashCode() {
        return Objects.hash(this.name, this.field, this.amount);
    }


    public String toString() {
        return "MyService. " + "name: " + name + ", field: " + field + ", amount: " + amount;
    }
}
