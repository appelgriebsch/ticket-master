package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the t_artist database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Artist.findByArtistName",
                query = "SELECT a FROM Artist a WHERE a.displayname LIKE :artistName"),
        @NamedQuery(name = "Artist.getListByGenre",
                query = "SELECT a FROM Artist a WHERE a.genre.id = :genreID")
})
@Table(name = "t_artist")
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String displayname;
    private String firstname;
    private String lastname;
    private Genre Genre;
    private List<Event> Events;

    public Artist() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(nullable = false, length = 80)
    public String getDisplayname() {
        return this.displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }


    @Column(length = 40)
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    @Column(length = 40)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    //bi-directional many-to-one association to Genre
    @ManyToOne
    @JoinColumn(name = "genre", nullable = false)
    public Genre getGenre() {
        return this.Genre;
    }

    public void setGenre(Genre Genre) {
        this.Genre = Genre;
    }


    //bi-directional many-to-many association to Event
    @ManyToMany(mappedBy = "artists")
    public List<Event> getEvents() {
        return this.Events;
    }

    public void setEvents(List<Event> Events) {
        this.Events = Events;
    }

}