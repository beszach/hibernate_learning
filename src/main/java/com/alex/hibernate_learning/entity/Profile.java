package com.alex.hibernate_learning.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Set<Review> reviews = new HashSet<>();

    public Profile() {
    }

    public Profile(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review){
        if(reviews == null){
            reviews = new HashSet<>();
        }
        reviews.add(review);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
