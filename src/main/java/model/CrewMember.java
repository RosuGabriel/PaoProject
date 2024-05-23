package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CrewMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected LocalDate born;
    @ManyToMany(mappedBy = "crew")
    protected List<Item> items;

    CrewMember() {

    }
    CrewMember(String _name, LocalDate _born){
        name = _name;
        born = _born;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public void show() {
        System.out.println("[Crew Member]: Name: " + name + " Born: " + born);
    }
}
