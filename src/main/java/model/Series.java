package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Series extends Item {
    private int seasonsNumber;

    public Series() {
        super();
    }
    public Series(String _title, LocalDate _releaseDate) {
        super(_title, _releaseDate);
    }

    public int getSeasons() {
        return seasonsNumber;
    }
    public void setSeasons(int num) {
        seasonsNumber = num;
    }

    @Override
    public void show(){
        System.out.println("[Series]: id: " + id + ", title: " + title + ", number of seasons: " + seasonsNumber +  ", release date: " + releaseDate);
    }
}
