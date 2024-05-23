package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Director extends CrewMember {
    public Director() {
        super();
    }
    public Director(String _name, LocalDate _born) {
        super(_name, _born);
    }

    @Override
    public void show() {
        System.out.println("[Director]: Name: " + name + " Born: " + born);
    }
}
