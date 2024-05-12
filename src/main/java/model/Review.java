package model;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rating;
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public Review() {

    }
    public Review(AppUser _user, Item _item) {
        user = _user;
        item = _item;
    }
    public Review(AppUser _user, Item _item, int _rating) {
        user = _user;
        item = _item;
        rating = _rating;
    }
    public Review(AppUser _user, Item _item, int _rating, String _text) {
        user = _user;
        item = _item;
        rating = _rating;
        text = _text;
    }

    public int getRating() {
        return rating;
    }
    public String getText() {
        return text;
    }
    public void setRating(int _rating) {
        rating = _rating;
    }
    public void setText(String _text) {
        text = _text;
    }
    public void show() {
        System.out.println("[Review from " + user.getName() + "]: Rating: " + rating + "/10");
        if(text != null) {
            if (text.isBlank())
                System.out.println(text);
        }
    }
}
