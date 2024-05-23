package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Actor extends CrewMember {
    public Actor() {
        super();
    }
    public Actor(String _name, LocalDate _born) {
        super(_name, _born);
    }

    @Override
    public void show() {
        System.out.println("[Actor]: Name: " + name + " Born: " + born);
    }
}
