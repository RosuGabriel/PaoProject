package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Director extends CrewMember {
    public Director() {
        super();
    }

    @Override
    public void show() {
        System.out.println("[Director]: Name: " + name + " Born: " + born);
    }
}
