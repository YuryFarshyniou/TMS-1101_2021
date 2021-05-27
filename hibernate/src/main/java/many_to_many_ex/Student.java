package many_to_many_ex;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    private int id;
    private String mark;
    private String name;
    @ManyToMany(mappedBy = "student")
    private List<Laptop> laptop = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", name='" + name + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
