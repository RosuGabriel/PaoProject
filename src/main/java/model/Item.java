package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String title;
    protected LocalDate releaseDate;
    protected LocalDate postDate;

    @ManyToMany
    @JoinTable(
            name = "item_crew",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "crew_id")
    )
    private List<CrewMember> crew;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Item() {
        reviews = new ArrayList<>();
        postDate = LocalDate.now();
    }
    public Item(String _title, LocalDate _releaseDate) {
        reviews = new ArrayList<>();
        title = _title;
        releaseDate = _releaseDate;
        postDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewMember> _crew) {
        crew = _crew;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> _reviews) {
        reviews = _reviews;
    }
    public void addReview(Review _review) {
        reviews.add(_review);
    }
    public void addCrew(CrewMember _crew) {
        crew.add(_crew);
    }
    public void show() {
        System.out.println("[Product]: id: " + id + ", title: " + title + ", release date: " + releaseDate);
    }
    public void showCrew() {
        for(var crewMember : crew) {
            crewMember.show();
        }
    }
}
