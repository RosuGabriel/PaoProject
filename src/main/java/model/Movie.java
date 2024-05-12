package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Movie extends Item {
    public Movie() {
        super();
    }
    public Movie(String _title, LocalDate _releaseDate) {
        super(_title, _releaseDate);
    }

    @Override
    public void show() {
        System.out.println("[Movie]: id: " + id + ", title: " + title + ", release date: " + releaseDate);
    }
}
