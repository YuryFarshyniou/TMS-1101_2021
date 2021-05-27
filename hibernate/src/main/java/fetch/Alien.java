package fetch;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Alien {
    @Id
    private int id;
    private String name;

    /*When we use FetchType.EAGER, than like in sql,we use left join.*/
    @OneToMany(mappedBy = "alien", fetch = FetchType.EAGER)
    private List<Laptop> laps = new ArrayList<>();

    public Alien(int id, String name, List<Laptop> laps) {
        this.id = id;
        this.name = name;
        this.laps = laps;
    }

    public Alien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Laptop> getLaps() {
        return laps;
    }

    public void setLaps(List<Laptop> laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name;
    }
}
