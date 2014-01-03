package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the t_rating database table.
 */
@Entity
@Table(name = "t_rating")
public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String comment;
    private Timestamp date;
    private BigDecimal rating;

    public Rating() {
    }


    @Id
    @Column(unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(length = 2147483647)
    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    //@Temporal( TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Timestamp getDate() {
        return this.date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    @Column(nullable = false, precision = 131089)
    public BigDecimal getRating() {
        return this.rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

}