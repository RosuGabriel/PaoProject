package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Actor extends CrewMember {
    public Actor() {
        super();
    }

    @Override
    public void show() {
        System.out.println("[Actor]: Name: " + name + " Born: " + born);
    }
}
