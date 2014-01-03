package de.fhdw.ify208.ticketmaster.dataaccess;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the t_genre database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Genre.findByName",
                query = "SELECT g FROM Genre g WHERE g.displayname LIKE :genreName"),
        @NamedQuery(name = "Genre.All",
                query = "SELECT g FROM Genre g")
})
@Table(name = "t_genre")
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String description;
    private String displayname;
    private List<Artist> Artists;

    public Genre() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(length = 2147483647)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(nullable = false, length = 20)
    public String getDisplayname() {
        return this.displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }


    //bi-directional many-to-one association to Artist
    @OneToMany(mappedBy = "genre")
    public List<Artist> getArtists() {
        return this.Artists;
    }

    public void setArtists(List<Artist> Artists) {
        this.Artists = Artists;
    }

}