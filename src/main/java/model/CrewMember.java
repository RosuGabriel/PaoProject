package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CrewMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected String born;
    @ManyToMany(mappedBy = "crew")
    protected List<Item> items;

    public void show() {
        System.out.println("[Crew Member]: Name: " + name + " Born: " + born);
    }
}
