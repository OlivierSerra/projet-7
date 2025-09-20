package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String moodysRating;
    private String sandPrating;
    private String fitchRating;
    private int orderNumber;

    public Rating() {
        // required by JPA
    }

    // attendu par le test: (String, String, String, int)
    public Rating(String moodysRating, String sandPrating, String fitchRating, int orderNumber) {
        this.moodysRating = moodysRating;
        this.sandPrating = sandPrating;
        this.fitchRating = fitchRating;
        this.orderNumber = orderNumber;
    }

    public Integer getId() { return id; }

    public Integer setId(Integer id) {
        return id;
    }

    public String getMoodysRating() {
        return moodysRating;
    }

    public void setMoodysRating(String moodysRating) {
        this.moodysRating = moodysRating;
    }

    public String getSandPrating() {
        return sandPrating;
    }

    public void setSandPrating(String sandPrating) {
        this.sandPrating = sandPrating;
    }

    public String getFitchRating() {
        return fitchRating;
    }

    public void setFitchRating(String fitchRating) {
        this.fitchRating = fitchRating;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}